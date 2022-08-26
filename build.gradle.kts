buildscript {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
	dependencies {
		classpath(libs.android.gradlePlugin)
		classpath(libs.kotlin.gradlePlugin)

		// https://stackoverflow.com/a/41958982/3853058
		classpath(libs.dependencyVersion.gradlePlugin)

		// NOTE: Do not place your application dependencies here; they belong in the individual module build.gradle files
	}
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	// FIXME
	//id(BuildPlugins.gradleVersionPlugin) version libs.versions.dependencyVersion.get()
	id(BuildPlugins.gradleVersionPlugin) version "0.42.0"
	id("com.android.library") version "7.2.2" apply false
	id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.register("clean").configure {
	delete("build")
}