package com.spiral_root.android.test_app.log

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.util.Log
import com.spiral_root.android.domain.util.notNull
import timber.log.Timber.DebugTree
import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FileLoggingTree(private val context: Context) : DebugTree() {

	@SuppressLint("LogNotTimber")
	override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
		val path = "log"
		val now = LocalDateTime.now()
		val fileNameTimeStamp: String = DateTimeFormatter.ISO_LOCAL_DATE.format(now)
		val logTimeStamp: String = DateTimeFormatter.ofPattern("yyyy MMM dd E 'at' hh:mm:ss:SSS").format(now)
		val fileName = "$fileNameTimeStamp.html"

		try {
			// Create file.
			val file: File? =
				getFile(context, path, fileName)
			// If file created or exists save logs.
			file.notNull {
				FileWriter(it, true).use { writer ->
					writer.append(
						"<p style=\"background:lightgray;\"><strong "
								+ "style=\"background:lightblue;\">&nbsp&nbsp"
					)
						.append(logTimeStamp)
						.append(" :&nbsp&nbsp</strong><strong>&nbsp&nbsp")
						.append(tag)
						.append("</strong> - ")
						.append(message)
						.append("</p>")
						.flush()
				}
			}
		} catch (e: Exception) {
			Log.e(LOG_TAG, "Error while logging into file : $e")
		}
	}

	override fun createStackElementTag(element: StackTraceElement): String? {
		// Add log statements line number to the log.
		return super.createStackElementTag(element) + " - " + element.lineNumber
	}

	companion object {
		private val LOG_TAG = FileLoggingTree::class.java.simpleName

		/**
		 * Helper method to create / get file.
		 */
		private fun getFile(context: Context, path: String, fileName: String): File? {
			var file: File? = null
			if (externalStorageAvailable) {
				val root = File(
					context.getExternalFilesDir(null)!!.absolutePath,
					path
				)
				var dirExists = true
				if (!root.exists()) {
					dirExists = root.mkdirs()
				}
				if (dirExists) {
					file = File(root, fileName)
				}
			}
			return file
		}

		/**
		 * Helper method to determine if external storage is available
		 */
		private val externalStorageAvailable: Boolean
			get() = Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
	}
}