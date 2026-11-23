package com.example.campustasks.domain

object TaskFactory {

    fun create(
        id: String,
        title: String,
        description: String? = null,
        priority: TaskPriority = TaskPriority.MEDIUM,
        estimatedMinutes: Int,
        tags: Set<String> = emptySet()
    ): CreateTaskResult {

        val normalizedTitle = title.trim()
        val normalizedTags = tags
            .map { it.trim().lowercase() }
            .filter { it.isNotEmpty() }
            .toSet()

        val errors = TaskValidator.validate(
            title = normalizedTitle,
            estimatedMinutes = estimatedMinutes,
            tags = normalizedTags
        )

        if (id.isBlank()) {
            return CreateTaskResult.Failure(
                errors + "ID tidak boleh kosong."
            )
        }

        if (errors.isNotEmpty()) {
            return CreateTaskResult.Failure(errors)
        }

        val task = Task(
            id = id.trim(),
            title = normalizedTitle,
            description = description?.trim(),
            priority = priority,
            estimatedMinutes = estimatedMinutes,
            tags = normalizedTags
        )

        return CreateTaskResult.Success(task)
    }
}