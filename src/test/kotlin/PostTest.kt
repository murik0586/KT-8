package ru.netology

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import ru.netology.Post.Post
import ru.netology.Post.View
import ru.netology.PostAndEntites.Comment
import ru.netology.PostAndEntites.CommentDonut
import ru.netology.PostAndEntites.CommentThread
import ru.netology.exceptions.*
import ru.netology.service.WallService


class PostTest {

    @Test
    fun add() {
        val result = WallService.add(
            Post(
                0,
                1,
                "Мурат",
                "Всем привет!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        assertEquals(1, result.id)
    }

    @Test
    fun updateTrue() {
        val service1 = WallService
        service1.add(
            Post(
                3,
                1,
                "Мурат",
                "Всем привет!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        service1.add(
            Post(
                1,
                6,
                "Мурат",
                "Всем привет!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = false,
                copyRight = null
            )
        )
        service1.add(
            Post(
                2,
                4,
                "Мурат1",
                "Всем приветec!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null,
            )
        )
        val update1 = Post(
            3,
            4,
            "Мурат",
            "dsfsdgsdgsdg!",
            likes = 2,
            date = 0,
            friendsOnly = true,
            //comments = Comment(1,2,null,null,null,null,null,null,null,null),
            view = View(),
            canPin = null,
            copyRight = null
        )
        val result = service1.update(update1)
        assertTrue(result)
    }

    @Test
    fun update2False() {
        val service1 = WallService
        service1.add(
            Post(
                3,
                1,
                "Мурат",
                "Всем привет!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        service1.add(
            Post(
                1,
                6,
                "Мурат",
                "Всем привет!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = true,
                copyRight = null
            )
        )
        service1.add(
            Post(
                2,
                4,
                "Мурат1",
                "Всем приветec!",
                likes = 0,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val update1 = Post(
            4,
            4,
            "Мурат",
            "dsfsdgsdgsdg!",
            likes = 2,
            date = 0,
            friendsOnly = true,
            //comments = Comment(1,2,null,null,null,null,null,null,null,null),
            view = View(),
            canPin = null,
            copyRight = null
        )
        val result1 = service1.update(update1)
        assertFalse(result1)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowFalse() {
        val service1 = WallService
        val firstPost = service1.add(
            Post(
                1,
                4,
                "Мурат",
                "dsfsdgsdgsdg!",
                likes = 2,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val firstComment = service1.createComment(
            2,
            Comment(
                1,
                4,
                10,
                "Привет, Мир!",
                donut = CommentDonut(true, " "),
                1,
                attachments = arrayOf(),
                replyToComment = 1, parentsStack = arrayOf(), thread = CommentThread(null,null,null,null,null)
            )
        )
    }

    @Test
    fun shouldThrowTrue() {
        val service1 = WallService
        val firstPost = service1.add(
            Post(
                1,
                4,
                "Мурат",
                "dsfsdgsdgsdg!",
                likes = 2,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val postId = firstPost.id
        val firstComment = service1.createComment(
            1,
            Comment(
                1,
                4,
                10,
                "Привет, Мир!!",
                donut = CommentDonut(true, " "),
                1,
                attachments = arrayOf(),
                replyToComment = 1, parentsStack = arrayOf(), thread = CommentThread(null,null,null,null,null)
            )
        )
        assertNotNull(firstComment)
    }
    @Test
    fun reportComment() {
        val service = WallService
        val firstPost = service.add(
            Post(
                1,
                4,
                "Мурат",
                "dsfsdgsdgsdg!",
                likes = 2,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val postId = firstPost.id
        val firstComment = service.createComment(
            postId,  Comment(
                10,
                222,
                10,
                "Привет, Мир!",
                donut = CommentDonut(true, " "),
                1,
                attachments = arrayOf(),
                replyToComment = 1, parentsStack = arrayOf(), thread = CommentThread(null,null,null,null,null)
            )
        )
        val report = service.report(firstComment.id, 0)
        assertNotNull(report)
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportNonExistingComment() {
        val service = WallService
        val firstPost = service.add(
            Post(
                1,
                4,
                "Мурат",
                "dsfsdgsdgsdg!",
                likes = 2,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val postId = -firstPost.id
        val firstComment = service.createComment(
            postId, Comment(
                2,
                10,
                10,
                "Привет, Мир!",
                donut = CommentDonut(true, " "),
                1,
                attachments = arrayOf(),
                replyToComment = 1, parentsStack = arrayOf(), thread = CommentThread(null,null,null,null,null)
            )
        )
        val report = service.report(firstComment.id, 1)
    }

    @Test(expected = ReasonNotFoundException::class)
    fun reportCommentWithNonExistingReason() {
        val service = WallService
        val firstPost = service.add(
            Post(
                1,
                4,
                "Мурат",
                "dsfsdgsdgsdg!",
                likes = 2,
                date = 0,
                friendsOnly = true,
                //comments = Comment(1,2,null,null,null,null,null,null,null,null),
                view = View(),
                canPin = null,
                copyRight = null
            )
        )
        val postId = firstPost.id
        val firstComment = service.createComment(
            postId,     Comment(
                0,
                222,
                10,
                "Привет, Мир!",
                donut = CommentDonut(true, " "),
                1,
                attachments = arrayOf(),
                replyToComment = 1, parentsStack = arrayOf(), thread = CommentThread(null,null,null,null,null)
            )
        )
        service.report(-firstComment.id, 10)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
}