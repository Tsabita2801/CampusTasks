package com.example.campustasks.domain

import org.junit.Assert.*
import org.junit.Test

class TaskValidatorTest {

    @Test
    fun validTitleAndEstimate() {
        val result = TaskValidator.validate(
            title = "Belajar Kotlin",
            estimatedMinutes = 60,
            tags = setOf("Android")
        )
        assertTrue(result.isEmpty())
    }

    @Test
    fun blankTitleIsInvalid() {
        val result = TaskValidator.validate(
            title = "",
            estimatedMinutes = 60,
            tags = emptySet()
        )
        assertTrue(result.any { it.contains("Title") })
    }

    @Test
    fun titleWithThreeCharactersIsValid() {
        val result = TaskValidator.validate(
            title = "ABC",
            estimatedMinutes = 60,
            tags = emptySet()
        )
        assertFalse(result.any { it.contains("Title") })
    }

    @Test
    fun titleWithEightyOneCharactersIsInvalid() {
        val result = TaskValidator.validate(
            title = "A".repeat(81),
            estimatedMinutes = 60,
            tags = emptySet()
        )
        assertTrue(result.any { it.contains("Title") })
    }

    @Test
    fun estimateOfFiveMinutesIsValid() {
        val result = TaskValidator.validate(
            title = "Belajar",
            estimatedMinutes = 5,
            tags = emptySet()
        )
        assertFalse(result.any { it.contains("Estimasi") })
    }

    @Test
    fun estimateOfFourHundredEightyOneIsInvalid() {
        val result = TaskValidator.validate(
            title = "Belajar",
            estimatedMinutes = 481,
            tags = emptySet()
        )
        assertTrue(result.any { it.contains("Estimasi") })
    }
}