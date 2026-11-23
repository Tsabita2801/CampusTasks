
package com.example.campustasks.domain

object TaskQueries {

    fun filterByStatus(
        tasks: List<Task>,
        status: TaskStatus
    ): List<Task> {
        return tasks.filter { it.status == status }
    }

    fun filterByPriority(
        tasks: List<Task>,
        priority: TaskPriority
    ): List<Task> {
        return tasks.filter { it.priority == priority }
    }

    fun search(
        tasks: List<Task>,
        keyword: String
    ): List<Task> {
        return tasks.filter {
            it.title.contains(keyword, ignoreCase = true) ||
                    it.description.orEmpty().contains(keyword, ignoreCase = true)
        }
    }

    fun sortByPriority(
        tasks: List<Task>
    ): List<Task> {
        val priorityOrder = mapOf(
            TaskPriority.HIGH to 1,
            TaskPriority.MEDIUM to 2,
            TaskPriority.LOW to 3
        )

        return tasks.sortedBy { priorityOrder[it.priority] }
    }

    fun completedTasks(
        tasks: List<Task>
    ): List<Task> {
        return tasks.filter { it.status == TaskStatus.DONE }
    }

    fun totalEstimatedMinutes(
        tasks: List<Task>
    ): Int {
        return tasks.sumOf { it.estimatedMinutes }
    }
}
