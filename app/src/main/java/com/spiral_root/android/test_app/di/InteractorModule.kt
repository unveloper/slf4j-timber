package com.spiral_root.android.test_app.di

import com.spiral_root.android.domain.interaction.ExampleInteractor
import com.spiral_root.android.domain.interaction.ExampleInteractorImpl
import com.spiral_root.android.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

	@Provides
	@Singleton
	internal fun provideExampleInteractor(
		exampleRepository: ExampleRepository
	): ExampleInteractor = ExampleInteractorImpl(exampleRepository)
}