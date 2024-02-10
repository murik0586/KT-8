package ru.netology.attachments

class DocAttachment(val doc: Doc?) : Attachment("Doc"){
val dowlandDoc: Any
    get() {
        return if (doc == Doc()) return doc else false

    }

}

fun main() {
    println( DocAttachment(doc = null).dowlandDoc)
}

data class Doc(
    val id: Int? = null,//	Идентификатор документа.
    val ownerId: Int? = null, //Идентификатор пользователя, загрузившего документ.
    val title: String? = null,//Название документа.
    val size: Int? = null,// Размер документа в байтах.
    val ext: String? = null,//расширение документа.
    val url: String? = null//Адрес документа, по которому его можно загрузить.
)