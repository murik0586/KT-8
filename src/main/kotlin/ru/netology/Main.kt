package ru.netology

import ru.netology.Post.*
import ru.netology.attachments.*


fun main() {

//        val attachment1: Attachment = VideoAttachment(null)
//    val attachment2: Attachment = AudioAttachment(null)
//    val attachment3: Attachment = LinkAttachment(null)
//    val attachment4: Attachment = PhotoAttachment(null)
//    val attachment5: Attachment = DocAttachment(null)
//    println(attachment1.type)
//    println(attachment2.type)
//    println(attachment3.type)
//    println(attachment4.type)
//    println(attachment5.type)
//    val list = mutableListOf(1, 2, 3)
//    list.swap(0, 2)
//    println(list)
//val strList = mutableListOf("one","two", "Three")
//    strList.swap(0,1)
//    println(strList)
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
    val post1 = mutableListOf(
        Post(
            id = 1,
            1,
            "Мурат",
            "Всем привет!",
            likes = 2,
            date = 0,
            friendsOnly = true,
            //comments = Comment(1,2,null,null,null,null,null,null,null,null),
            view = View(),
            canPin = true,
            copyRight = null
        ),
        Post(
            id = 4,
            2,
            "Амина",
            "Всем привет!",
            likes = 3,
            date = 0,
            friendsOnly = true,
            //comments = Comment(1,2,null,null,null,null,null,null,null,null),
            view = View(),
            canPin = true,
            copyRight = null
        )
    )
//    val short = fun (post: Post) = post.likes > 0
//    val full: (Post) -> Boolean = ::liked
//    println(short == full)
//    println(short === full)

//    val likedList = post1.filter(fun (post: Post) = post.likes > 0)
    post1.filter { it.likes > 0 }
    post1.filterIndexed() { _, post -> post.likes > 0 }

// println(post1.maxOf { it.likes })
    println(post1.maxByOrNull { it.likes })
    println(post1.map { it.likes })
    post1.forEach{ println(it.likes) }
    println(post1.reduceRight { post, acc ->  acc.copy(likes = acc.likes + post.likes)})
    println(post1.fold(0) { acc,post ->  acc + post.likes})
}

//fun <E> MutableList<E>.swap(index1: Int, index2: Int) {
//    val e1 = get(index1)
//    val e2 = get(index2)
//    this[index1] = e2
//    this[index2] = e1
//}
//fun liked(post: Post) = post.likes > 0


