plugins {
	id(BuildPlugins.androidApplication)
	id(BuildPlugins.kotlinAndroid)
	id(BuildPlugins.kotlinKapt)
	id(BuildPlugins.hilt)
}

android {
	compileSdk = libs.versions.compileSdk.get().toInt()
	buildToolsVersion = libs.versions.buildTools.get()

	defaultConfig {
		applicationId = "com.spiral_root.android.slf4j_timber"
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = Android.testInstrumentationRunner

		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		getByName("release") {
			isShrinkResources = true
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
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
	}
	packagingOptions {
		resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
	}
}

dependencies {
	implementation(project(Modules.Domain))
	implementation(project(Modules.Data))

	coreLibraryDesugaring(libs.desugarJdk)

	implementation(libs.androidx.core.ktx)
	implementation(libs.bundles.androidx.compose)
	implementation(libs.androidx.lifecycle.runtime)
	// Hilt
	implementation(libs.hilt.android)
	implementation(libs.androidx.hilt.navigation.compose)
	implementation(libs.androidx.hilt.work)
	kapt(libs.hilt.compiler)
	kapt(libs.androidx.hilt.compiler)
	// Log
	implementation(libs.timber)

	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.junit)
	androidTestImplementation(libs.espresso.core)
	androidTestImplementation(libs.androidx.compose.junit4)
	// Hilt
	androidTestImplementation(libs.hilt.android.testing)
	kaptAndroidTest(libs.hilt.android.compiler)
}