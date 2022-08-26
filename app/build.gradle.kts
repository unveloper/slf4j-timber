plugins {
	id(BuildPlugins.androidApplication)
	id(BuildPlugins.kotlinAndroid)
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
	/*implementation 'androidx.core:core-ktx:1.7.0'
	implementation "androidx.compose.ui:ui:$compose_version"
	implementation 'androidx.compose.material3:material3:1.0.0-alpha01'
	implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
	implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
	implementation 'androidx.activity:activity-compose:1.3.1'
	testImplementation 'junit:junit:4.13.2'
	androidTestImplementation 'androidx.test.ext:junit:1.1.3'
	androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
	androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
	debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
	debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"*/

	coreLibraryDesugaring(libs.desugarJdk)

	implementation(libs.androidx.core.ktx)
	implementation(libs.bundles.androidx.compose)
	implementation(libs.androidx.lifecycle.runtime)
	// Log
	implementation(libs.timber)

	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.junit)
	androidTestImplementation(libs.espresso.core)
	androidTestImplementation(libs.androidx.compose.junit4)
}