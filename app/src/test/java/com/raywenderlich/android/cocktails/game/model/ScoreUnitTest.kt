package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Test

class ScoreUnitTest {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val score = Score()

        score.incrementScore()

        Assert.assertEquals(1, score.currentScore)
    }

    @Test
    fun
        whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val score = Score()

        score.incrementScore()

        Assert.assertEquals(1, score.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val score = Score(highestScore = 10)

        score.incrementScore()

        Assert.assertEquals(10, score.highestScore)
    }
}