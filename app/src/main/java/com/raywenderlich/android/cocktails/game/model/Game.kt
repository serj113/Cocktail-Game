package com.raywenderlich.android.cocktails.game.model

class Game(var questions: List<Question> = listOf(), var score: Score = Score()) {
    var currentQuestion = 0

    fun nextQustion(): Question? {
        return questions.getOrNull(currentQuestion++)
    }

    fun answer(question: Question, option: String) {
        if (question.answer(option)) {
            score.incrementScore()
        }
    }
}
