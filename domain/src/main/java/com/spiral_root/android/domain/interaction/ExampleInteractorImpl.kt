package com.spiral_root.android.domain.interaction

import com.spiral_root.android.domain.model.ExampleObject
import com.spiral_root.android.domain.repository.ExampleRepository
import kotlin.random.Random

class ExampleInteractorImpl(private val repository: ExampleRepository) : ExampleInteractor {

	override suspend fun getObject(): ExampleObject {
		return repository.retrieveObject(Random.nextInt(0, 100))
	}
}