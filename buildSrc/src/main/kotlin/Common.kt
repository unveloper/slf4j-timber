object BuildPlugins {
	const val androidApplication = "com.android.application"
	const val androidLibrary = "com.android.library"
	const val kotlinAndroid = "org.jetbrains.kotlin.android"
	const val kotlinParcelize = "kotlin-parcelize"
	const val kotlinKapt = "kotlin-kapt"
	const val kotlinSerialization = "org.jetbrains.kotlin.plugin.serialization"
	const val kotlinKsp = "com.google.devtools.ksp"
	const val gradleVersionPlugin = "com.github.ben-manes.versions"
	const val hilt = "dagger.hilt.android.plugin"
	const val navigationSageArgs = "androidx.navigation.safeargs.kotlin"
	const val protoBuf = "com.google.protobuf"
	const val javaLibrary = "java-library"
	const val kotlin = "org.jetbrains.kotlin.jvm"
	const val kotlinAtomicFU = "kotlinx-atomicfu"
}

object Android {
	const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Modules {
	const val Data = ":data"
	const val Domain = ":domain"
}
