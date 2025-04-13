package com.learnings.demo.insta.profile.domain.model

data class UserProfile(
    val name: String,
    val username: String,
    val bio: String,
    val profileImageUrl: String,
    val posts: Int,
    val followers: Int,
    val following: Int,
    val highlights: List<Highlight>,
    val postsImages: List<Post>
)