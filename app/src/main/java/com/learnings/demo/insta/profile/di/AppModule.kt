package com.learnings.demo.insta.profile.di

import com.learnings.demo.insta.profile.presentation.profile.viewModel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    // ViewModel
    viewModel { ProfileViewModel(get()) }
}
