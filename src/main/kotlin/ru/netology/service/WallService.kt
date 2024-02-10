package ru.netology.service

import ru.netology.Post.Post
import ru.netology.PostAndEntites.Comment
import ru.netology.PostAndEntites.Report
import ru.netology.exceptions.CommentNotFoundException
import ru.netology.exceptions.PostNotFoundException
import ru.netology.utils.VkUtils


object WallService {
    private var posts = emptyList<Post>().toMutableList()
    private var comments = emptyList<Comment>().toMutableList()
    private var reports = emptyList<Report>().toMutableList()
    private var id = 1

    fun add(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }

    fun update(postInput: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (postInput.id == post.id) {
                posts[index] = postInput.copy()
                return true
            }

        }
        return false
    }

//    private fun findPostById(postId: Int): Post? {
//        for (post in posts) {
//            if (post.id == postId) {
//                return post
//            }
//        }
//        return null
//    }

//    private fun findCommentById(commentId: Int): Comment? {
//        for (comment in comments) {
//            if (comment.id == commentId) {
//                return comment
//            }
//        }
//        return null
//    }

    fun report(commentId: Int, reason: Int): Report {
        val comment = comments[VkUtils.findIndexById(comments,commentId) ?: throw CommentNotFoundException("No comment with id $commentId")]
        reports += Report(comment.fromId, comment.id, reason)
        return reports.last()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        if (VkUtils.findIndexById(posts, postId) != null) {
            comments += comment.copy(id = ++id)
            return comments.last()
        }
        throw PostNotFoundException("No post with id $postId")
    }

    fun clear() {
        posts.clear()
        comments.clear()
        reports.clear()

    }
}
