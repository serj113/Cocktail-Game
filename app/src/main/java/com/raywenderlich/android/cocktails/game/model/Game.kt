package com.raywenderlich.android.cocktails.game.model

class Game(var questions: List<Question> = listOf(), var highestScore: Int = 0) {
    var currentScore = 0
    var currentQuestion = 0

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) highestScore = currentScore
    }

    fun nextQustion(): Question? {
        return questions.getOrNull(currentQuestion++)
    }

}
