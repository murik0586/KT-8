package ru.netology.service

import ru.netology.postAndEntites.Post
import ru.netology.postAndEntites.Comment
import ru.netology.postAndEntites.Report
import ru.netology.exceptions.CommentNotFoundException
import ru.netology.exceptions.PostNotFoundException
import ru.netology.exceptions.ReasonNotFoundException
import ru.netology.utils.VkUtils

class WallService {

    private var id: Int = 0
    private var posts = mutableListOf<Post>()
    private var comments = mutableListOf<Comment>()
    private var reports = mutableListOf<Report>()

    fun clear() {
        id = 0
        posts.clear()
        comments.clear()
        reports.clear()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        if (VkUtils.findIndexById(posts, postId) != null) {
            comments += comment.copy(id = ++id)
            return comments.last()
        }
        throw PostNotFoundException("No post with id $postId")
    }

    fun report(commentId: Int, reason: Int): Report {
        val comment = comments[VkUtils.findIndexById(comments, commentId)
            ?: throw CommentNotFoundException("No comment with id $commentId")]
        reports += Report(comment.fromId, comment.id, reason)
        return reports.last()
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postFromArray) in posts.withIndex()) {
            if (postFromArray.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }
}

data class Report(
    val ownerId: Int,
    val commentId: Int
) {
    private var reason: Int? = null
    private val reasons = arrayOf(0, 1, 2, 3, 4, 5, 6, 8)

    constructor(ownerId: Int, commentId: Int, reason: Int) : this(ownerId, commentId) {
        if (reasons.contains(reason)) {
            this.reason = reason
        } else {
            throw ReasonNotFoundException("Reason #$reason is not found")
        }
    }
}
