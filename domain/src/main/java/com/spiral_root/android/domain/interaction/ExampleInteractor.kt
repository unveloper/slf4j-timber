package com.spiral_root.android.domain.interaction

import com.spiral_root.android.domain.model.ExampleObject

interface ExampleInteractor {

	suspend fun getObject(id: Int): ExampleObject
}