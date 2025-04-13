package com.learnings.demo.insta.profile.presentation.profile.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnings.demo.insta.profile.domain.model.UserProfile
import com.learnings.demo.insta.profile.domain.usecase.GetUserProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(private val userProfileUseCase: GetUserProfileUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<UIState> =
        MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            val profileData = userProfileUseCase.execute()
            if (profileData != null) {
                _uiState.update { UIState.Loaded(profileData) }
            } else {
                _uiState.update { UIState.Error("Failed to load user profile!") }
            }
        }
    }
}

/**
 * States for UI
 */
sealed class UIState {
    data object Loading : UIState()
    class Error(val message: String?) : UIState()
    class Loaded(val userProfile: UserProfile) : UIState()
}

