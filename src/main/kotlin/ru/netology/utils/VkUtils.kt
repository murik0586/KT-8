package ru.netology.utils

import ru.netology.PostAndEntites.Entity
import ru.netology.PostAndEntites.User


object VkUtils {
    private var UserId = 0
    val USER1 = User(UserId++)
    val USER2 = User(UserId++)

    fun createNewUser(): User {
        return User(UserId++)
    }

    fun findIndexById(entities: Collection<Entity>, entityId: Int): Int? {
        val entity = try {
            entities.first { it.id == entityId }
        } catch (e: NoSuchElementException) {
            return null
        }
        return entities.indexOf(entity)
    }
}