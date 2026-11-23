
package com.example.campustasks.domain

import org.junit.Assert.*
import org.junit.Test

class TaskQueriesTest {

    private val tasks = listOf(
        Task(
            id = "1",
            title = "Belajar Kotlin",
            priority = TaskPriority.HIGH,
            status = TaskStatus.TODO,
            estimatedMinutes = 60
        ),
        Task(
            id = "2",
            title = "Mengerjakan UI",
            priority = TaskPriority.MEDIUM,
            status = TaskStatus.IN_PROGRESS,
            estimatedMinutes = 90
        ),
        Task(
            id = "3",
            title = "Membaca Modul",
            priority = TaskPriority.LOW,
            status = TaskStatus.DONE,
            estimatedMinutes = 30
        )
    )

    @Test
    fun filterByStatusReturnsMatchingTasks() {
        val result = TaskQueries.filterByStatus(tasks, TaskStatus.DONE)

        assertEquals(1, result.size)
        assertEquals("3", result.first().id)
    }

    @Test
    fun filterByPriorityReturnsMatchingTasks() {
        val result = TaskQueries.filterByPriority(tasks, TaskPriority.HIGH)

        assertEquals(1, result.size)
        assertEquals("1", result.first().id)
    }

    @Test
    fun searchIsCaseInsensitive() {
        val result = TaskQueries.search(tasks, "KOTLIN")

        assertEquals(1, result.size)
        assertEquals("1", result.first().id)
    }

    @Test
    fun sortByPriorityPlacesHighFirst() {
        val result = TaskQueries.sortByPriority(tasks)

        assertEquals(TaskPriority.HIGH, result.first().priority)
        assertEquals(TaskPriority.LOW, result.last().priority)
    }

    @Test
    fun completedTasksReturnsOnlyDoneTasks() {
        val result = TaskQueries.completedTasks(tasks)

        assertTrue(result.all { it.status == TaskStatus.DONE })
        assertEquals(1, result.size)
    }

    @Test
    fun totalEstimatedMinutesReturnsCorrectSum() {
        val result = TaskQueries.totalEstimatedMinutes(tasks)

        assertEquals(180, result)
    }
}
