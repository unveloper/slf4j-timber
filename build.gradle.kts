buildscript {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
	dependencies {
		classpath(libs.android.gradlePlugin)
		classpath(libs.kotlin.gradlePlugin)
		classpath(libs.hilt.android.gradlePlugin)

		// https://stackoverflow.com/a/41958982/3853058
		classpath(libs.dependencyVersion.gradlePlugin)

		classpath(libs.gradleNexus.publishPlugin)

		// NOTE: Do not place your application dependencies here; they belong in the individual module build.gradle files
	}
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	// FIXME
	//id(BuildPlugins.gradleVersionPlugin) version libs.versions.dependencyVersion.get()
	id(BuildPlugins.gradleVersionPlugin) version "0.42.0"
	//id(BuildPlugins.gradleVersionPlugin) version libs.versions.gradleNexusPublishPlugin.get()
	id(BuildPlugins.gradleNexusPublishPlugin) version "1.1.0"
}

apply(from = "${rootProject.projectDir}/scripts/publish-root.gradle")

tasks.register("clean").configure {
	delete("build")
}

// Publishing Android library to Maven guide: https://medium.com/mobile-app-development-publication/upload-to-mavencentral-made-easy-for-android-library-30d2b83af0c7
// Gradle commando to publish: publishReleasePublicationToMavenLocal