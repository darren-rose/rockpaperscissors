package com.gmail.darrenofwales.rockpaperscissors;

/**
 * Created by darrenrose on 30/11/2014.
 */
public enum Choice {
    ROCK {
        @Override
        public Result plays(Choice opponent) {
            if(opponent==ROCK){
                return Result.DRAW;
            }
            if(opponent==PAPER){
                return Result.LOSE;
            }
            return Result.WIN;
        }
    },
    PAPER {
        @Override
        public Result plays(Choice opponent) {
            if(opponent==ROCK){
                return Result.WIN;
            }
            if(opponent==PAPER){
                return Result.DRAW;
            }
            return Result.LOSE;
        }
    },
    SCISSORS {
        @Override
        public Result plays(Choice opponent) {
            if(opponent==ROCK){
                return Result.LOSE;
            }
            if(opponent==PAPER){
                return Result.WIN;
            }
            return Result.DRAW;
        }
    };

    public enum Result {
        WIN,
        LOSE,
        DRAW
    }

    public abstract Result plays(Choice opponent);

}
