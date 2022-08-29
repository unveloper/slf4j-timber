package com.spiral_root.android.test_app

import android.app.Application
import com.spiral_root.android.test_app.log.FileLoggingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Program : Application() {

	override fun onCreate() {
		super.onCreate()

		if (BuildConfig.DEBUG) {
			// https://proandroiddev.com/managing-logging-in-a-multi-module-android-application-eb966fb7fedc
			Timber.plant(Timber.DebugTree())
		} else {
			Timber.plant(FileLoggingTree(this))
		}
		Timber.i("I'm alive!")
	}
}