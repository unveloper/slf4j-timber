package com.spiral_root.android.slf4j_timber

import org.slf4j.ILoggerFactory
import org.slf4j.IMarkerFactory
import org.slf4j.helpers.BasicMarkerFactory
import org.slf4j.helpers.NOPMDCAdapter
import org.slf4j.spi.MDCAdapter
import org.slf4j.spi.SLF4JServiceProvider

/**
 * slf4j v2 with ServiceLoader, http://www.slf4j.org/faq.html#changesInVersion200
 * Inspired by https://github.com/qos-ch/slf4j/blob/master/slf4j-simple/src/main/java/org/slf4j/simple/SimpleServiceProvider.java
 */
class TimberAndroidServiceProvider : SLF4JServiceProvider {
	private var loggerFactory: ILoggerFactory? = null
	private var markerFactory: IMarkerFactory? = null
	private var mdcAdapter: MDCAdapter? = null

	override fun initialize() {
		loggerFactory = TimberAndroidLoggerFactory()
		markerFactory = BasicMarkerFactory()
		mdcAdapter = NOPMDCAdapter()
	}

	override fun getLoggerFactory(): ILoggerFactory? = loggerFactory

	override fun getMarkerFactory(): IMarkerFactory? = markerFactory

	override fun getMDCAdapter(): MDCAdapter? = mdcAdapter

	override fun getRequestedApiVersion(): String {
		return REQUESTED_API_VERSION
	}

	companion object {
		var REQUESTED_API_VERSION = "2.0.99"
	}
}