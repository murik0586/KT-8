package ru.netology

import ru.netology.postAndEntites.*
import ru.netology.attachments.*
import ru.netology.service.*


fun main() {
    val service = WallService()
    service.add(
        Post(
            ownerId = 2_323_445,
            fromId = 234_845,
            createdBy = 0,
            date = 1_698_000_333,
            text = "Hello Kotlin!"
        )
    )
    val attachment: Attachment = PhotoAttachment(
        Photo(
            0,
            0,
            0,
            0,
            "Фото",
            1_688_777_888,
            emptyArray(),
            1024,
            768
        )
    )
    whenSealed(attachment)
}

fun whenSealed(attachment: Attachment) {
    when (attachment) {
        is AudioAttachment -> println("This is AudioAttachment")
        is VideoAttachment -> println("This is VideoAttachment")
        is PhotoAttachment -> println("This is PhotoAttachment")
        is LinkAttachment -> println("This is LinkAttachment")
        is DocAttachment -> println("This is DocAttachment")
    }
}


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

//    val short = fun (post: Post) = post.likes > 0
//    val full: (Post) -> Boolean = ::liked
//    println(short == full)
//    println(short === full)

//    val likedList = post1.filter(fun (post: Post) = post.likes > 0)
//    post1.filter { it.likes > 0 }
//    post1.filterIndexed() { _, post -> post.likes > 0 }

// println(post1.maxOf { it.likes })
//    println(post1.maxByOrNull { it.likes })
//    println(post1.map { it.likes })
//    post1.forEach{ println(it.likes) }
//    println(post1.reduceRight { post, acc ->  acc.copy(likes = acc.likes + post.likes)})
//    println(post1.fold(0) { acc,post ->  acc + post.likes})
//}

//fun <E> MutableList<E>.swap(index1: Int, index2: Int) {
//    val e1 = get(index1)
//    val e2 = get(index2)
//    this[index1] = e2
//    this[index2] = e1
//}
//fun liked(post: Post) = post.likes > 0


