package ru.netology.postAndEntites

data class User(
    override val id: Int,
    val name: String,
    val surname: String
) : Entity {
    override fun toString(): String {
        return "$name $surname"
    }
}