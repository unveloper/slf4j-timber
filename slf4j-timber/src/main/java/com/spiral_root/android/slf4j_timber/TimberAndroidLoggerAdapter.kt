package com.spiral_root.android.slf4j_timber

import android.util.Log
import org.slf4j.helpers.MarkerIgnoringBase
import org.slf4j.helpers.MessageFormatter
import timber.log.Timber

/**
 * A simple implementation that delegates all log requests to the Jake Wharton's Timber logging facilities.
 * Note that this logger does not support [org.slf4j.Marker].
 * Methods taking marker data as parameter simply invoke the eponymous method without the Marker argument, discarding any marker data in the process.
 *
 * The logging levels specified for SLF4J can be almost directly mapped to the levels that exist in Timber platform.
 * The following table shows the mapping implemented by this logger.
 *
 *       | SLF4J | Android                    |
 *       |-------|----------------------------|
 *       | TRACE | [android.util.Log.VERBOSE] |
 *       | DEBUG | [android.util.Log.DEBUG]   |
 *       | INFO  | [android.util.Log.INFO]    |
 *       | WARN  | [android.util.Log.WARN]    |
 *       | ERROR | [android.util.Log.ERROR]   |
 *
 *
 * Use loggers as usual:
 *
 * - Declare a logger:
 *
 * `val logger: Logger = LoggerFactory.getLogger(MyClass::class.java)`
 *
 *  - Invoke logging methods, e.g.:
 *
 * `logger.debug("Some log message. Details: {}", someObject)`
 * `logger.debug("Some log message with varargs. Details: {}, {}, {}", someObject1, someObject2, someObject3)`
 *
 *
 * Logger instances created using the LoggerFactory are named either according to the name or the fully qualified class name of the class given as a parameter.
 * Each logger name will be used as the log message tag on the Android platform. No truncating will take place since Timber handles this itself.
 *
 * Inspired by: https://github.com/patrickfav/slf4j-timber, v1.0.1
 */
internal class TimberAndroidLoggerAdapter(tag: String?) : MarkerIgnoringBase() {

	/**
	 * Package access allows only [org.slf4j.impl.TimberAndroidLoggerFactory] to instantiateSimpleLogger instances.
	 */
	init {
		name = tag
	}

	/**
	 * Is this logger instance enabled for the VERBOSE level?
	 *
	 * @return True if this Logger is enabled for level VERBOSE, false otherwise.
	 */
	override fun isTraceEnabled(): Boolean {
		return isLoggable(Log.VERBOSE)
	}

	/**
	 * Log a message object at level VERBOSE.
	 *
	 * @param msg The message object to be logged.
	 */
	override fun trace(msg: String) {
		log(Log.VERBOSE, msg, null)
	}

	/**
	 * Log a message at level VERBOSE according to the specified format and argument.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for level VERBOSE.
	 *
	 * @param format The format string..
	 * @param arg    The argument..
	 */
	override fun trace(format: String, arg: Any?) {
		formatAndLog(Log.VERBOSE, format, arg)
	}

	/**
	 * Log a message at level VERBOSE according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the VERBOSE level.	 *
	 *
	 * @param format The format string.
	 * @param arg1   The first argument.
	 * @param arg2   The second argument.
	 */
	override fun trace(format: String, arg1: Any?, arg2: Any?) {
		formatAndLog(Log.VERBOSE, format, arg1, arg2)
	}

	/**
	 * Log a message at level VERBOSE according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the VERBOSE level.
	 *
	 * @param format   The format string.
	 * @param argArray An array of arguments.
	 */
	override fun trace(format: String, vararg argArray: Any?) {
		formatAndLog(Log.VERBOSE, format, arrayOf(argArray))
	}

	/**
	 * Log an exception (throwable) at level VERBOSE with an accompanying message.
	 *
	 * @param msg The message accompanying the exception.
	 * @param t   The exception (throwable) to log.
	 */
	override fun trace(msg: String, t: Throwable?) {
		log(Log.VERBOSE, msg, t)
	}

	/**
	 * Is this logger instance enabled for the DEBUG level?
	 *
	 * @return True if this Logger is enabled for level DEBUG, false otherwise.
	 */
	override fun isDebugEnabled(): Boolean {
		return isLoggable(Log.DEBUG)
	}

	/**
	 * Log a message object at level DEBUG.
	 *
	 * @param msg The message object to be logged.
	 */
	override fun debug(msg: String) {
		log(Log.DEBUG, msg, null)
	}

	/**
	 * Log a message at level DEBUG according to the specified format and argument.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for level DEBUG.
	 *
	 * @param format The format string.
	 * @param arg    The argument.
	 */
	override fun debug(format: String, arg: Any?) {
		formatAndLog(Log.DEBUG, format, arg)
	}

	/**
	 * Log a message at level DEBUG according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the DEBUG level.
	 *
	 * @param format The format string.
	 * @param arg1   The first argument.
	 * @param arg2   The second argument.
	 */
	override fun debug(format: String, arg1: Any?, arg2: Any?) {
		formatAndLog(Log.DEBUG, format, arg1, arg2)
	}

	/**
	 * Log a message at level DEBUG according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the DEBUG level.
	 *
	 * @param format   The format string.
	 * @param argArray An array of arguments.
	 */
	override fun debug(format: String, vararg argArray: Any?) {
		formatAndLog(Log.DEBUG, format, arrayOf(argArray))
	}

	/**
	 * Log an exception (throwable) at level DEBUG with an accompanying message.
	 *
	 * @param msg The message accompanying the exception.
	 * @param t   The exception (throwable) to log.
	 */
	override fun debug(msg: String, t: Throwable?) {
		log(Log.DEBUG, msg, t)
	}

	/**
	 * Is this logger instance enabled for the INFO level?
	 *
	 * @return True if this Logger is enabled for the INFO level, false otherwise.
	 */
	override fun isInfoEnabled(): Boolean {
		return isLoggable(Log.INFO)
	}

	/**
	 * Log a message object at the INFO level.
	 *
	 * @param msg The message object to be logged.
	 */
	override fun info(msg: String) {
		log(Log.INFO, msg, null)
	}

	/**
	 * Log a message at level INFO according to the specified format and argument.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the INFO level.
	 *
	 * @param format The format string.
	 * @param arg    The argument.
	 */
	override fun info(format: String, arg: Any?) {
		formatAndLog(Log.INFO, format, arg)
	}

	/**
	 * Log a message at the INFO level according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the INFO level.
	 *
	 * @param format The format string.
	 * @param arg1   The first argument.
	 * @param arg2   The second argument.
	 */
	override fun info(format: String, arg1: Any?, arg2: Any?) {
		formatAndLog(Log.INFO, format, arg1, arg2)
	}

	/**
	 * Log a message at level INFO according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the INFO level.
	 *
	 * @param format   The format string.
	 * @param argArray An array of arguments.
	 */
	override fun info(format: String, vararg argArray: Any?) {
		formatAndLog(Log.INFO, format, arrayOf(argArray))
	}

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying message.
	 *
	 * @param msg The message accompanying the exception.
	 * @param t   The exception (throwable) to log.
	 */
	override fun info(msg: String, t: Throwable?) {
		log(Log.INFO, msg, t)
	}

	/**
	 * Is this logger instance enabled for the WARN level?
	 *
	 * @return True if this Logger is enabled for the WARN level, false otherwise.
	 */
	override fun isWarnEnabled(): Boolean {
		return isLoggable(Log.WARN)
	}

	/**
	 * Log a message object at the WARN level.
	 *
	 * @param msg The message object to be logged.
	 */
	override fun warn(msg: String) {
		log(Log.WARN, msg, null)
	}

	/**
	 * Log a message at the WARN level according to the specified format and argument.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the WARN level.
	 *
	 * @param format The format string.
	 * @param arg    The argument.
	 */
	override fun warn(format: String, arg: Any?) {
		formatAndLog(Log.WARN, format, arg)
	}

	/**
	 * Log a message at the WARN level according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the WARN level.
	 *
	 * @param format The format string.
	 * @param arg1   The first argument.
	 * @param arg2   The second argument.
	 */
	override fun warn(format: String, arg1: Any?, arg2: Any?) {
		formatAndLog(Log.WARN, format, arg1, arg2)
	}

	/**
	 * Log a message at level WARN according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the WARN level.ì
	 *
	 * @param format   The format string.
	 * @param argArray An array of arguments.
	 */
	override fun warn(format: String, vararg argArray: Any?) {
		formatAndLog(Log.WARN, format, arrayOf(argArray))
	}

	/**
	 * Log an exception (throwable) at the WARN level with an accompanying message.
	 *
	 * @param msg The message accompanying the exception.
	 * @param t   The exception (throwable) to log.
	 */
	override fun warn(msg: String, t: Throwable?) {
		log(Log.WARN, msg, t)
	}

	/**
	 * Is this logger instance enabled for level ERROR?
	 *
	 * @return True if this Logger is enabled for level ERROR, false otherwise.
	 */
	override fun isErrorEnabled(): Boolean {
		return isLoggable(Log.ERROR)
	}

	/**
	 * Log a message object at the ERROR level.
	 *
	 * @param msg The message object to be logged.
	 */
	override fun error(msg: String) {
		log(Log.ERROR, msg, null)
	}

	/**
	 * Log a message at the ERROR level according to the specified format and argument.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the ERROR level.
	 *
	 * @param format The format string.
	 * @param arg    The argument.
	 */
	override fun error(format: String, arg: Any?) {
		formatAndLog(Log.ERROR, format, arg)
	}

	/**
	 * Log a message at the ERROR level according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the ERROR level.
	 *
	 * @param format The format string.
	 * @param arg1   The first argument.
	 * @param arg2   The second argument.
	 */
	override fun error(format: String, arg1: Any?, arg2: Any?) {
		formatAndLog(Log.ERROR, format, arg1, arg2)
	}

	/**
	 * Log a message at level ERROR according to the specified format and arguments.
	 *
	 * This form avoids superfluous object creation when the logger is disabled for the ERROR level.
	 *
	 * @param format   The format string.
	 * @param argArray An array of arguments.
	 */
	override fun error(format: String, vararg argArray: Any?) {
		formatAndLog(Log.ERROR, format, arrayOf(argArray))
	}

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message.
	 *
	 * @param msg The message accompanying the exception.
	 * @param t   The exception (throwable) to log.
	 */
	override fun error(msg: String, t: Throwable?) {
		log(Log.ERROR, msg, t)
	}

	private fun formatAndLog(priority: Int, format: String, vararg argArray: Any?) {
		if (isLoggable(priority)) {
			val ft = MessageFormatter.arrayFormat(format, argArray)
			logInternal(priority, ft.message, ft.throwable)
		}
	}

	private fun log(priority: Int, message: String, throwable: Throwable?) {
		if (isLoggable(priority)) {
			logInternal(priority, message, throwable)
		}
	}

	/**
	 * Currently all levels are enabled, since Timber will decide if the log will be actually used.
	 *
	 * @return Always true.
	 */
	private fun isLoggable(priority: Int): Boolean {
		return Timber.treeCount > 0
	}

	private fun logInternal(priority: Int, message: String?, throwable: Throwable?) {
		Timber.tag(name)
		if (throwable != null) {
			if (message != null) {
				Timber.log(priority, throwable, message)
			} else {
				Timber.log(priority, throwable)
			}
		} else {
			Timber.log(priority, message)
		}
	}
}