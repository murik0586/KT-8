package ru.netology.Post

import ru.netology.PostAndEntites.Entity
import ru.netology.attachments.Attachment

data class Post(
    override val id: Int,//1 id поста
    val fromId: Int,//2 id владельца
    val authorName: String,//7
    val contentText: String,//4
    val date: Long,//3
    val likes: Int,//8
    val friendsOnly: Boolean, //5 Только для друзей или нет
    val view: View,//9. Просмотры
    val canPin: Boolean?,//10. Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val copyRight: CopyRight?,
    val attachment: Array<Attachment> = arrayOf(),//11. Закрепленные файлы.
): Entity



data class View(
    val count: Int = 0
)

data class CopyRight(
    val id: Int?,
    val link: String?,
    val name: String?,
    val type: String?
)
