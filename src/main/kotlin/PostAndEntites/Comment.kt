package ru.netology.PostAndEntites

import ru.netology.attachments.Attachment
import ru.netology.exceptions.ReasonNotFoundException

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int?,
    val text: String?,
    val donut: CommentDonut?,
    val replyToUser: Int?,
    val replyToComment: Int?,
    val attachments: Array<Attachment>?,
    val parentsStack: Array<Int>?,
    val thread: CommentThread?
)


data class CommentThread(
    val count: Int?,
    val items: Array<Comment>?,
    val canPost: Boolean?,
    val showReplyButton: Boolean?,
    val groupsCanPost: Boolean?
)


data class CommentDonut(
    val isDon: Boolean,
    val placeholder: String
)

data class Report(
    val id: Int,
    val commentId: Int
) {
    private var reason: Int? = null
    private val reasons = arrayOf(0,1,2,3,4,5,6,7,8)
    constructor(id: Int, commentId: Int,reason:Int): this(id, commentId){
        if (reasons.contains(reason)) {
            this.reason = reason
        } else {
            throw ReasonNotFoundException("Reason #$reason is not found")
        }
    }
}