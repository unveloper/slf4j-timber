object BuildPlugins {
	const val androidApplication = "com.android.application"
	const val androidLibrary = "com.android.library"
	const val kotlinAndroid = "org.jetbrains.kotlin.android"
	const val kotlinKapt = "kotlin-kapt"
	const val gradleVersionPlugin = "com.github.ben-manes.versions"
	const val hilt = "dagger.hilt.android.plugin"
	const val javaLibrary = "java-library"
	const val kotlin = "org.jetbrains.kotlin.jvm"
	const val mavenPublish = "maven-publish"
	const val gradleNexusPublishPlugin = "io.github.gradle-nexus.publish-plugin"
}

object Android {
	const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Modules {
	const val Data = ":data"
	const val Domain = ":domain"
}
