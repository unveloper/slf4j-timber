package com.spiral_root.android.data.di

import com.spiral_root.android.data.repository.ExampleRepositoryImpl
import com.spiral_root.android.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	@Singleton
	internal fun provideExampleRepository(): ExampleRepository = ExampleRepositoryImpl()
}