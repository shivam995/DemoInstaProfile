package com.learnings.demo.insta.profile.data.repository

import com.learnings.demo.insta.profile.domain.model.Highlight
import com.learnings.demo.insta.profile.domain.model.Post
import com.learnings.demo.insta.profile.domain.model.UserProfile
import com.learnings.demo.insta.profile.domain.repository.ProfileRepository
import kotlinx.coroutines.delay
import java.util.UUID

class ProfileRepositoryImpl : ProfileRepository {
    override suspend fun getUserProfile(): UserProfile {
        val randomUrl = "https://picsum.photos/150/150?random=${UUID.randomUUID()}"
        // mimicking the api call delay
        delay(500)
        return UserProfile(
            name = "Shivam Jaiswal",
            username = "myselfshivam_",
            bio = "Woods are lovely dark and deep, but I have promises to keep and miles to go, before I sleep! 🌍",
            profileImageUrl = "https://picsum.photos/200",
            posts = 120,
            followers = 3400,
            following = 180,
            highlights = List(6) { Highlight(title = "Highlight", imageUrl = randomUrl) },
            postsImages = List(22) { Post(imageUrl = randomUrl, title = "") }
        )
    }
}