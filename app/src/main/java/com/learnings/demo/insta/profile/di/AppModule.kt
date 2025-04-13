package com.learnings.demo.insta.profile.di

import com.learnings.demo.insta.profile.data.repository.ProfileRepositoryImpl
import com.learnings.demo.insta.profile.domain.repository.ProfileRepository
import com.learnings.demo.insta.profile.domain.usecase.GetUserProfileUseCase
import com.learnings.demo.insta.profile.presentation.profile.viewModel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    // Repository
    single<ProfileRepository> { ProfileRepositoryImpl() }

    // UseCase
    single { GetUserProfileUseCase(get()) }

    // ViewModel
    viewModel { ProfileViewModel(get()) }
}
