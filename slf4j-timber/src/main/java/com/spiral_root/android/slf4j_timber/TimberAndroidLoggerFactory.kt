package com.spiral_root.android.slf4j_timber

import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

/**
 * TimberAndroidLoggerFactory is an implementation of [ILoggerFactory] returning the appropriately named [TimberAndroidLoggerFactory] instance.
 */
class TimberAndroidLoggerFactory : ILoggerFactory {

	private val loggerMap: ConcurrentMap<String, Logger> = ConcurrentHashMap()

	/**
	 * Return an appropriate [TimberAndroidLoggerAdapter] instance by name.
	 */
	override fun getLogger(name: String?): Logger {
		val tag = name ?: ANONYMOUS_TAG
		var logger = loggerMap[tag]
		if (logger == null) {
			val newInstance: Logger = TimberAndroidLoggerAdapter(tag)
			val oldInstance = loggerMap.putIfAbsent(tag, newInstance)
			logger = oldInstance ?: newInstance
		}
		return logger
	}

	companion object {
		const val ANONYMOUS_TAG = "null"
	}
}