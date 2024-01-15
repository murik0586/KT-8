package ru.netology.attachments

class AudioAttachment(val audio: Audio?): Attachment("Audio") {
val dowlandAudio: Any
    get() {
        return if (audio == Audio()) return audio else false

    }

}

fun main() {
    println( AudioAttachment(audio = null).dowlandAudio)
}
data class Audio (
    val id: Int? = null, //Идентификатор аудиозаписи.
    val ownerId: Int? = null,//	Идентификатор владельца аудиозаписи.
    val artist: String? = null, //Исполнитель.
    val title: String? = null,//Название композиции.
    val duration: Int? = null,//Длительность аудиозаписи в секундах.
    val url: String? = null,//Ссылка на mp3.
)