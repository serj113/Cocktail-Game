package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Test

class GameUnitTests {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val game = Game()

        game.incrementScore()

        Assert.assertEquals(1, game.currentScore)
    }

    @Test
    fun
        whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val game = Game()
        game.incrementScore()
        Assert.assertEquals(1, game.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val game = Game(highestScore = 10)
        game.incrementScore()
        Assert.assertEquals(10, game.highestScore)
    }

    @Test
    fun whenNextQuestion_shouldReturnPreviousQuestion() {
        val question1 = Question("Correct", "Incorrect")
        val question2 = Question("True", "False")
        val game = Game(listOf(
            question1,
            question2
        ))

        val question = game.nextQustion()

        Assert.assertEquals(question, question1)
    }

    @Test
    fun whenNextQuestion_inTheLast_shouldReturnNull() {
        val question1 = Question("Correct", "Incorrect")
        val game = Game(listOf(
            question1
        ))

        game.nextQustion()

        val question = game.nextQustion()

        Assert.assertNull(question)
    }
}