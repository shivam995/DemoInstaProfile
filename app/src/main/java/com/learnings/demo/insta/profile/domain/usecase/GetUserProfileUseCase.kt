package com.learnings.demo.insta.profile.domain.usecase

import com.learnings.demo.insta.profile.domain.model.UserProfile
import com.learnings.demo.insta.profile.domain.repository.ProfileRepository

class GetUserProfileUseCase(private val repository: ProfileRepository) {

    suspend fun execute(): UserProfile? {
        return repository.getUserProfile()
    }
}