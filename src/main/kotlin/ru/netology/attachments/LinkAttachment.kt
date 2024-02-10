package ru.netology.attachments

data class LinkAttachment(val link: Link?): Attachment("Link")  {
    val dowlandLink: Any
    get() {
        return if (link == Link()) return link else false

    }

}

fun main() {
    println( LinkAttachment(link = null).dowlandLink)
}


data class Link (
    val url: String? = null, //URL ссылки.
    val title: String? = null, //Заголовок ссылки.
    val caption: String? = null,//Подпись ссылки (если имеется).
    val description: String? = null,//	Описание ссылки.
)
