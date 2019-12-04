package com.raywenderlich.android.cocktails.game.model

class Score(var highestScore: Int = 0) {
    var currentScore = 0

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) highestScore = currentScore
    }
}
