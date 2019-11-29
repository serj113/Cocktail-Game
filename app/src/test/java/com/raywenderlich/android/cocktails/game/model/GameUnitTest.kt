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
}