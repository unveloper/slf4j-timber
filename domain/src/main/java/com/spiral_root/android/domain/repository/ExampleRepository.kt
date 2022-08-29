package com.spiral_root.android.domain.repository

import com.spiral_root.android.domain.model.ExampleObject

interface ExampleRepository {

	suspend fun retrieveObject(id: Int): ExampleObject
}