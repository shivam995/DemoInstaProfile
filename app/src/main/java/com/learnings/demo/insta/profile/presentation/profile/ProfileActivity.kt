package com.learnings.demo.insta.profile.presentation.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.learnings.demo.insta.profile.presentation.profile.components.ProfileScreen
import com.learnings.demo.insta.profile.presentation.profile.viewModel.ProfileViewModel
import com.learnings.demo.insta.profile.ui.theme.DemoInstaProfileTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel: ProfileViewModel = ProfileViewModel()

        setContent {
            DemoInstaProfileTheme {
                // A surface container using the 'background' color from the theme
                ProfileScreen()
            }
        }
    }
}