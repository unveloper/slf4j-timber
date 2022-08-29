package com.spiral_root.android.data.repository

import com.spiral_root.android.domain.model.ExampleObject
import com.spiral_root.android.domain.repository.ExampleRepository
import kotlinx.coroutines.delay

class ExampleRepositoryImpl : ExampleRepository {

	override suspend fun retrieveObject(id: Int): ExampleObject {
		delay(500)
		return ExampleObject(id, "description_$id")
	}
}