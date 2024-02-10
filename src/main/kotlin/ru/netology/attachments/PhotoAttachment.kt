package ru.netology.attachments

class PhotoAttachment(val photo: Photo?): Attachment("Photo") {
    val dowlandPhoto: Any
        get() {
            return if (photo == Photo(emptyArray = emptyArray(), i = 1024, i1 = 768)) return photo else false

        }

}

fun main() {
    println( PhotoAttachment(photo = null).dowlandPhoto )
}

data class Photo(
    val id: Int? = null, //Идентификатор фотографии.
    val albumId: Int? = null,//Идентификатор альбома, в котором находится фотография.
    val ownerId: Int? = null,//	Идентификатор владельца фотографии.
    val userId: Int? = null,// Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
    val text: String? = null,//Текст описания фотографии
    val date: Int? = null, //	Дата добавления в формате Unixtime.
    val emptyArray: Array<Any>,
    val i: Int,
    val i1: Int,
)