package com.spiral_root.android.slf4j_timber

import org.junit.Assert
import timber.log.Timber

/**
 * A mock timber for testing to check the expected properties.
 */
class MockTimberTree internal constructor() : Timber.Tree() {

	private var isExpectedSet = false
	private var expectedPriority = 0
	private var expectedTag: String? = null
	private var message: String? = null
	private var t: Throwable? = null

	fun setNexExpectedCall(expectedPriority: Int, expectedTag: String?, message: String?, t: Throwable?) {
		this.expectedPriority = expectedPriority
		this.expectedTag = expectedTag
		this.message = message
		this.t = t
		isExpectedSet = true
	}

	@Synchronized
	override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
		println("[" + toString() + "]" + " prio: " + priority + " - tag: " + tag + " - message: " + message + " - throwable: " + t)
		if (isExpectedSet) {
			Assert.assertEquals("log priority should match", expectedPriority, priority)
			Assert.assertEquals("log tag should match", expectedTag, tag)
			if (t != null) {
				Assert.assertTrue(message.startsWith(this.message!!))
				Assert.assertEquals("log throwable should match", this.t, t)
			} else {
				Assert.assertEquals("log message should match", this.message, message)
			}
		}
		isExpectedSet = false
	}
}