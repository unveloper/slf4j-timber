package com.spiral_root.android.domain.interaction

import com.spiral_root.android.domain.model.ExampleObject
import com.spiral_root.android.domain.repository.ExampleRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.random.Random

class ExampleInteractorImpl(private val repository: ExampleRepository) : ExampleInteractor {

	override suspend fun getObject(): ExampleObject {
		val id = Random.nextInt(0, 100)
		logger.debug("Requesting object with id = $id")
		return repository.retrieveObject(id)
	}

	companion object {
		private val logger: Logger = LoggerFactory.getLogger(ExampleInteractorImpl::class.java)
	}
}