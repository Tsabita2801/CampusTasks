
package com.example.campustasks.domain

import org.junit.Assert.*
import org.junit.Test

class TaskCollectionTest {

    private val tasks = listOf(
        Task(
            id = "1",
            title = "Belajar Kotlin",
            estimatedMinutes = 60
        ),
        Task(
            id = "2",
            title = "Mengerjakan Tugas",
            estimatedMinutes = 90
        ),
        Task(
            id = "3",
            title = "Membaca Modul",
            estimatedMinutes = 30
        )
    )

    @Test
    fun findByIdReturnsMatchingTask() {
        val result = TaskCollection.findById(tasks, "2")

        assertNotNull(result)
        assertEquals("Mengerjakan Tugas", result?.title)
    }

    @Test
    fun findByIdReturnsNullWhenNotFound() {
        val result = TaskCollection.findById(tasks, "99")

        assertNull(result)
    }

    @Test
    fun findAllByIdsReturnsMatchingTasks() {
        val result = TaskCollection.findAllByIds(
            tasks,
            setOf("1", "3")
        )

        assertEquals(2, result.size)
    }

    @Test
    fun findAllByIdsReturnsEmptyListWhenNoIdsMatch() {
        val result = TaskCollection.findAllByIds(
            tasks,
            setOf("99", "100")
        )

        assertTrue(result.isEmpty())
    }
}
