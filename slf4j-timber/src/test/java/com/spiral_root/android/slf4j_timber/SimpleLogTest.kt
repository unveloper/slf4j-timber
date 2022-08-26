package com.spiral_root.android.slf4j_timber

import android.util.Log
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import timber.log.Timber

class SimpleLogTest {

	private val logger = LoggerFactory.getLogger(TAG)
	private var mockTimberTree: MockTimberTree? = null

	@Before
	fun setup() {
		Timber.uprootAll()
		mockTimberTree = MockTimberTree()
		Timber.plant(mockTimberTree!!)
	}

	@After
	fun tearDown() {
		Timber.uprootAll()
	}

	@Test
	fun testVerboseLog() {
		logger.trace("a trace message")
		logger.trace("a trace exception", IllegalStateException())
		logger.trace("a trace {}", "placeholder msg")
		logger.trace("a trace {} {}", "placeholder msg1", "placeholder msg2")
		logger.trace("a trace {} {} {}", "placeholder msg1", "placeholder msg2", "placeholder msg3")

		testLog(Log.VERBOSE, "a trace message test", null)
		testLog(Log.VERBOSE, "a trace message test", IllegalStateException())
	}

	@Test
	fun testDebugLog() {
		logger.debug("a debug message")
		logger.debug("a debug {}", "placeholder msg")
		logger.debug("a debug {} {}", "placeholder msg1", "placeholder msg2")
		logger.debug("a debug {} {} {}", "placeholder msg1", "placeholder msg2", "placeholder msg3")
		logger.debug("a debug exception", IllegalStateException())

		testLog(Log.DEBUG, "a debug message test", null)
		testLog(Log.DEBUG, "a debug message test", IllegalStateException())
	}

	@Test
	fun testInfoLog() {
		logger.info("a info message")
		logger.info("a info {}", "placeholder msg")
		logger.info("a info {} {}", "placeholder msg1", "placeholder msg2")
		logger.info("a info {} {} {}", "placeholder msg1", "placeholder msg2", "placeholder msg3")
		logger.info("a info exception", IllegalStateException())

		testLog(Log.INFO, "a info message test", null)
		testLog(Log.INFO, "a info message test", RuntimeException())
	}

	@Test
	fun testWarnLog() {
		logger.warn("a warn message")
		logger.warn("a warn {}", "placeholder msg")
		logger.warn("a warn {} {}", "placeholder msg1", "placeholder msg2")
		logger.warn("a warn {} {} {}", "placeholder msg1", "placeholder msg2", "placeholder msg3")
		logger.warn("a warn exception", IllegalStateException())
		testLog(Log.WARN, "a warn message test", null)
		testLog(Log.WARN, "a warn message test", IllegalArgumentException())
	}

	@Test
	fun testErrorLog() {
		logger.error("a error message")
		logger.error("a error {}", "placeholder msg")
		logger.error("a error {} {}", "placeholder msg1", "placeholder msg2")
		logger.error("a error {} {} {}", "placeholder msg1", "placeholder msg2", "placeholder msg3")
		logger.error("a error exception test", IllegalStateException())

		testLog(Log.ERROR, "a error message test", null)
		testLog(Log.ERROR, "a error message test", IllegalAccessError())
	}

	@Test
	fun testIsLoggable() {
		Assert.assertTrue(logger.isTraceEnabled)
		Assert.assertTrue(logger.isDebugEnabled)
		Assert.assertTrue(logger.isInfoEnabled)
		Assert.assertTrue(logger.isWarnEnabled)
		Assert.assertTrue(logger.isErrorEnabled)
	}

	@Test
	fun testIsLoggable_noTreesPlanted() {
		Timber.uprootAll()
		Assert.assertFalse(logger.isTraceEnabled)
		Assert.assertFalse(logger.isDebugEnabled)
		Assert.assertFalse(logger.isInfoEnabled)
		Assert.assertFalse(logger.isWarnEnabled)
		Assert.assertFalse(logger.isErrorEnabled)
	}

	private fun testLog(priority: Int, message: String, t: Throwable?) {
		mockTimberTree!!.setNexExpectedCall(priority, TAG, message, t)
		when (priority) {
			Log.VERBOSE -> if (t != null) {
				logger.trace(message, t)
			} else {
				logger.trace(message)
			}
			Log.DEBUG -> if (t != null) {
				logger.debug(message, t)
			} else {
				logger.debug(message)
			}
			Log.INFO -> if (t != null) {
				logger.info(message, t)
			} else {
				logger.info(message)
			}
			Log.WARN -> if (t != null) {
				logger.warn(message, t)
			} else {
				logger.warn(message)
			}
			Log.ERROR -> if (t != null) {
				logger.error(message, t)
			} else {
				logger.error(message)
			}
			else -> throw IllegalStateException("unknown prio")
		}
	}

	companion object {
		private const val TAG = "SimpleLogTest.Log"
	}
}