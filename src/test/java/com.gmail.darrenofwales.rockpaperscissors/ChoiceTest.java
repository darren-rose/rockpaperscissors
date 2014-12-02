package com.gmail.darrenofwales.rockpaperscissors;

import org.junit.Test;

import static com.gmail.darrenofwales.rockpaperscissors.Choice.Result;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by darrenrose on 30/11/2014.
 */
public class ChoiceTest {

    @Test
    public void verifyWinScenarios(){
        // Given
        Choice human = Choice.ROCK;
        Choice computer = Choice.SCISSORS;
        // When
        Result actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.WIN));

        // Given
        human = Choice.PAPER;
        computer = Choice.ROCK;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.WIN));

        // Given
        human = Choice.SCISSORS;
        computer = Choice.PAPER;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.WIN));
    }

    @Test
    public void verifyLoseScenarios(){
        // Given
        Choice human = Choice.ROCK;
        Choice computer = Choice.PAPER;
        // When
        Result actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.LOSE));

        // Given
        human = Choice.PAPER;
        computer = Choice.SCISSORS;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.LOSE));

        // Given
        human = Choice.SCISSORS;
        computer = Choice.ROCK;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.LOSE));
    }

    @Test
    public void verifyDrawScenarios(){
        // Given
        Choice human = Choice.ROCK;
        Choice computer = Choice.ROCK;
        // When
        Result actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.DRAW));

        // Given
        human = Choice.PAPER;
        computer = Choice.PAPER;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.DRAW));

        // Given
        human = Choice.SCISSORS;
        computer = Choice.SCISSORS;
        // When
        actual = human.plays(computer);
        // Then
        assertThat(actual, is(Result.DRAW));
    }

}
