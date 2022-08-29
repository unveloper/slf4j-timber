package com.spiral_root.android.domain.interaction

import com.spiral_root.android.domain.model.ExampleObject
import com.spiral_root.android.domain.repository.ExampleRepository

class ExampleInteractorImpl(private val repository: ExampleRepository) : ExampleInteractor {

	override suspend fun getObject(id: Int): ExampleObject {
		return repository.retrieveObject(id)
	}
}