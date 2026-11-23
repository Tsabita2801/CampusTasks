
package com.example.campustasks.domain

object TaskCollection {

    fun <T : Identifiable> findById(
        items: List<T>,
        id: String
    ): T? {
        return items.find { it.id == id }
    }

    fun <T : Identifiable> findAllByIds(
        items: List<T>,
        ids: Set<String>
    ): List<T> {
        return items.filter { it.id in ids }
    }
}
