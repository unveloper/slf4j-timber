plugins {
	id(BuildPlugins.androidLibrary)
	id(BuildPlugins.kotlinAndroid)
	id(BuildPlugins.kotlinKapt)
}

android {
	namespace = "com.spiral_root.android.data"
	compileSdk = libs.versions.compileSdk.get().toInt()
	buildToolsVersion = libs.versions.buildTools.get()

	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
		version = 1

		testInstrumentationRunner = Android.testInstrumentationRunner
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = true
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		// Flag to enable support for the new language APIs
		isCoreLibraryDesugaringEnabled = true
		// Sets Java compatibility to Java 1.8
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = libs.versions.appJvmTarget.get()
		freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
	}
}

dependencies {
	implementation(project(Modules.Domain))

	coreLibraryDesugaring(libs.desugarJdk)

	// Coroutines
	implementation(libs.kotlin.coroutines.core)
	implementation(libs.kotlin.coroutines.android)
	// Hilt
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	kapt(libs.androidx.hilt.compiler)
	// Log
	implementation(libs.timber)

	// ---- Test
	testImplementation(libs.bundles.test.common)
	testImplementation(libs.mockito.kotlin)
	testImplementation(libs.kotlin.coroutines.test)

	androidTestImplementation(libs.androidx.test.junit)
	androidTestImplementation(libs.bundles.test.espresso)
}