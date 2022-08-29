package com.spiral_root.android.domain.util

/**
 * Executes [let] only if the value is not null.
 */
inline fun <T : Any, R> T?.notNull(callback: (T) -> R): R? {
	return this?.let(callback)
}