package com.learnings.demo.insta.profile.domain.repository

import com.learnings.demo.insta.profile.domain.model.UserProfile

interface ProfileRepository {
    suspend fun getUserProfile(): UserProfile?
}