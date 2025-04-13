package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.learnings.demo.insta.profile.presentation.profile.viewModel.ProfileViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = getViewModel()) {

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
    ) {
        item { ProfileHeader() }

    }
}
