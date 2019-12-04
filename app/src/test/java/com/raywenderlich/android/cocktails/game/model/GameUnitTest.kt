package com.raywenderlich.android.cocktails.game.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class GameUnitTests {
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

    @Test
    fun whenAnswering_shouldDelegateToQuestion() {
        val question = mockk<Question>(relaxed = true)
        val game = Game(listOf(question))

        game.answer(question, "OPTION")

        verify(exactly = 1) {
            question.answer("OPTION")
        }
    }

    @Test
    fun whenAnsweringCorrectly_shouldIncrementCurrentScore() {
        val question = mockk<Question>()
        every { question.answer(any()) } returns true
        val score = mockk<Score>(relaxed = true)
        val game = Game(listOf(question), score)

        game.answer(question, "OPTION")

        verify(exactly = 1) { score.incrementScore() }
    }

    @Test
    fun whenAnsweringIncorrectly_shouldNotIncrementCurrentScore() {
        val question = mockk<Question>()
        every { question.answer(any()) } returns false
        val score = mockk<Score>()
        val game = Game(listOf(question), score)

        game.answer(question, "OPTION")

        verify(exactly = 0) { score.incrementScore() }
    }
}