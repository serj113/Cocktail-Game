package com.raywenderlich.android.cocktails.game.model

class Question(val correctOption: String, val incorrectOption: String) {

    var answeredOption: String? = null

    fun answer(option: String): Boolean {
        if (option != correctOption && option != incorrectOption)
            throw IllegalArgumentException("Not a valid option")

        answeredOption = option

        return answeredOption == correctOption
    }

    fun getOptions(sort: (List<String>) -> List<String> = { it.shuffled() }): List<String> = sort(
        listOf(
            correctOption,
            incorrectOption
        )
    )
}
