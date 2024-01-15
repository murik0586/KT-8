package ru.netology.attachments

class VideoAttachment(val video: Video?): Attachment("Video")   {
    val dowlandVideo: Any
    get() {
        return if (video == Video()) return video else false

    }

}

fun main() {
    println( VideoAttachment(video = null).dowlandVideo)
}

data class Video (
    val id: Int? = null,//Идентификатор видеозаписи.
    val ownerId: Int? = null, //Идентификатор владельца видеозаписи.
    val title: String? = null,//Название видеозаписи.
    val description: String? = null,//Текст описания видеозаписи.
    val duration: Int? = null,//Длительность ролика в секундах.

)