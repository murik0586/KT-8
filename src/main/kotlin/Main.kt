package ru.netology

import ru.netology.Post.*
import ru.netology.attachments.*
import ru.netology.service.WallService

fun main() {
    val post = Post(
        1,
        1,
        "Мурат",
        "Всем привет!",
        likes = 0,
        date = 0,
        friendsOnly = true,
        //comments = Comment(1,2,null,null,null,null,null,null,null,null),
        view = View(),
        canPin = null,
        copyRight = null,
        attachment = arrayOf(VideoAttachment(Video()))//Пример добавления видео
    )
    val liked = post.copy(likes = post.likes + 1)
    val (id, authorId, _, content) = post
    println("$id,$authorId, $content")
    println(liked)
    val post1 = WallService.add(
        Post(
            id = id,
            1,
            "Мурат",
            "Всем привет!",
            likes = 0,
            date = 0,
            friendsOnly = true,
            //comments = Comment(1,2,null,null,null,null,null,null,null,null),
            view = View(),
            canPin = true,
            copyRight = null
        )
    )
    println(post1)
    val attachment1: Attachment = VideoAttachment(null)
    val attachment2: Attachment = AudioAttachment(null)
    val attachment3: Attachment = LinkAttachment(null)
    val attachment4: Attachment = PhotoAttachment(null)
    val attachment5: Attachment = DocAttachment(null)
    println(attachment1.type)
    println(attachment2.type)
    println(attachment3.type)
    println(attachment4.type)
    println(attachment5.type)


}



