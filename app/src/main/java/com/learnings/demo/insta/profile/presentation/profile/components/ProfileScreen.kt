package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learnings.demo.insta.profile.domain.model.UserProfile
import com.learnings.demo.insta.profile.presentation.profile.viewModel.ProfileViewModel
import com.learnings.demo.insta.profile.presentation.profile.viewModel.UIState

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is UIState.Loaded -> {
            MainContentView(userProfile = state.userProfile)
        }

        is UIState.Error -> {
            ErrorView(errorMessage = state.message)
        }

        is UIState.Loading -> {
            LoadingView()
        }
    }
}

@Composable
fun MainContentView(userProfile: UserProfile) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
    ) {
        item(key = 1) { ProfileHeader(profile = userProfile) }
        item(key = 2) { StoryHighlights(highlights = userProfile.highlights) }
        item(key = 3) { PostGrid(posts = userProfile.postsImages) }
    }

}


@Composable
fun ErrorView(errorMessage: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = errorMessage ?: "Something went wrong!",
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 20.sp, fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
