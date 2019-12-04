package com.raywenderlich.android.cocktails

import android.content.SharedPreferences
import com.raywenderlich.android.cocktails.common.network.CocktailsApi
import com.raywenderlich.android.cocktails.common.repository.CocktailsRepositoryImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.Test

class RepositoryUnitTest {
    @Test
    fun saveScore_shouldSaveToSharedPreferences() {
        val api: CocktailsApi = mockk()

        val sharedPreferencesEditor: SharedPreferences.Editor = mockk()
        val sharedPreferences: SharedPreferences = mockk()
        every { sharedPreferences.edit() } returns sharedPreferencesEditor
        val repository = CocktailsRepositoryImpl(api, sharedPreferences)
        val score = 100

        repository.saveHighScore(score)

        verifyOrder {
            sharedPreferencesEditor.putInt(any(), score)
            sharedPreferencesEditor.apply()
        }
    }
}