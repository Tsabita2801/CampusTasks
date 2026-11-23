
package com.example.campustasks.domain

object TaskValidator {

    fun validate(
        title: String,
        estimatedMinutes: Int,
        tags: Set<String>
    ): List<String> {
        val errors = mutableListOf<String>()

        if (title.trim().length !in 3..80) {
            errors.add("Title harus terdiri dari 3 sampai 80 karakter.")
        }

        if (estimatedMinutes !in 5..480) {
            errors.add("Estimasi harus berada antara 5 sampai 480 menit.")
        }

        if (tags.any { it.isBlank() }) {
            errors.add("Tag tidak boleh kosong.")
        }

        return errors
    }
}
