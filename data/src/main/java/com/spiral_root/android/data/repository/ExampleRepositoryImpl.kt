package com.spiral_root.android.data.repository

import com.spiral_root.android.domain.model.ExampleObject
import com.spiral_root.android.domain.repository.ExampleRepository
import kotlinx.coroutines.delay
import timber.log.Timber

class ExampleRepositoryImpl : ExampleRepository {

	override suspend fun retrieveObject(id: Int): ExampleObject {
		Timber.d("Retrieving object with id = $id")
		delay(500)
		return ExampleObject(id, "description_$id")
	}
}