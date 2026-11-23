
package com.example.campustasks.domain

import org.junit.Assert.*
import org.junit.Test

class TaskFactoryTest {

    @Test
    fun createTaskWithValidDataReturnsSuccess() {
        val result = TaskFactory.create(
            id = "1",
            title = "Belajar Kotlin",
            estimatedMinutes = 60,
            tags = setOf("Android")
        )

        assertTrue(result is CreateTaskResult.Success)
    }

    @Test
    fun createTaskWithBlankIdReturnsFailure() {
        val result = TaskFactory.create(
            id = "",
            title = "Belajar Kotlin",
            estimatedMinutes = 60
        )

        assertTrue(result is CreateTaskResult.Failure)
    }

    @Test
    fun createTaskWithBlankTitleReturnsFailure() {
        val result = TaskFactory.create(
            id = "1",
            title = "",
            estimatedMinutes = 60
        )

        assertTrue(result is CreateTaskResult.Failure)
    }

    @Test
    fun createTaskWithInvalidEstimateReturnsFailure() {
        val result = TaskFactory.create(
            id = "1",
            title = "Belajar Kotlin",
            estimatedMinutes = 500
        )

        assertTrue(result is CreateTaskResult.Failure)
    }

    @Test
    fun createTaskNormalizesTitleAndTags() {
        val result = TaskFactory.create(
            id = "1",
            title = "  Belajar Kotlin  ",
            estimatedMinutes = 60,
            tags = setOf(" Android ", "KOTLIN")
        )

        assertTrue(result is CreateTaskResult.Success)

        if (result is CreateTaskResult.Success) {
            assertEquals("Belajar Kotlin", result.task.title)
            assertEquals(setOf("android", "kotlin"), result.task.tags)
        }
    }

    @Test
    fun createTaskWithValidBoundaryEstimateReturnsSuccess() {
        val result = TaskFactory.create(
            id = "1",
            title = "Belajar Kotlin",
            estimatedMinutes = 480
        )

        assertTrue(result is CreateTaskResult.Success)
    }
}
