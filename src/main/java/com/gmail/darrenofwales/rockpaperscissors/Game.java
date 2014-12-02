package com.gmail.darrenofwales.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by darrenrose on 01/12/2014.
 */
public class Game {
    private Random random = new Random();

    public Choice randomChoice(){
        int i = random.nextInt(3);
        switch (i){
            case 0:
                return Choice.ROCK;
            case 1:
                return Choice.PAPER;
            default :
                return Choice.SCISSORS;
        }
    }

    public void introduction() {
        System.out.println("Rock Paper Scissors");
    }

    public int modeSelection() {
        while(true) {
            System.out.println("Enter 1 for Player vs Computer");
            System.out.println("Enter 2 for Computer vs Computer");
            System.out.println("Enter q to quit");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            if ("1".equals(line)) {
                return 1;
            }
            if ("2".equals(line)) {
                return 2;
            }
            if ("Q".equals(line.toUpperCase())) {
                return 3;
            }
            System.out.println("Invalid value.");
        }
    }

    public Choice playerChoice() {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Rock, Paper or Scissors");
            try {
                String playerChoice = in.nextLine();
                return Choice.valueOf(playerChoice.toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid value.");
            }
        }
    }

    public static void main(String[] args){
        Game game = new Game();
        game.introduction();

        while(true) {
            int mode = game.modeSelection();
            switch (mode) {
                case 1:
                    System.out.println("Player versus Computer");
                    System.out.println("Computer has chosen, make your choice.");
                    Choice computer = game.randomChoice();
                    Choice player = game.playerChoice();
                    Choice.Result result = player.plays(computer);
                    System.out.println("player " + result);
                    System.out.println("computer chose " + computer);
                    break;
                case 2:
                    System.out.println("Computer versus Computer");
                    Choice player1 = game.randomChoice();
                    System.out.println("Computer 1 has chosen " + player1);
                    Choice player2 = game.randomChoice();
                    System.out.println("Computer 2 has chosen " + player2);
                    result = player1.plays(player2);
                    System.out.println("Computer 1 " + result);
                    break;
                case 3:
                    System.out.println("Thanks for playing.");
                    System.exit(1);
                    break;
                default:
                System.out.println("Invalid value.");
                    break;
            }
        }
    }

}
