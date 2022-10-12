plugins {
	id(BuildPlugins.androidLibrary)
	id(BuildPlugins.kotlinAndroid)
}

ext {
	set("PUBLISH_GROUP_ID", "io.github.unveloper")
	set("PUBLISH_VERSION", "0.0.5")
	set("PUBLISH_ARTIFACT_ID", "slf4j-timber")
	set("PUBLISH_DESCRIPTION", "SLF4J binding for Timber - the famous logger for Android")
	set("PUBLISH_URL", "https://github.com/unveloper/slf4j-timber")
	set("PUBLISH_LICENSE_NAME", "Apache-2.0 license")
	set("PUBLISH_LICENSE_URL", "https://github.com/unveloper/slf4j-timber/blob/master/LICENSE.txt")
	set("PUBLISH_DEVELOPER_ID", "unveloper")
	set("PUBLISH_DEVELOPER_NAME", "Unveloper")
	set("PUBLISH_DEVELOPER_EMAIL", "down.the.spiral.root@gmail.com")
	set("PUBLISH_SCM_CONNECTION", "scm:git:github.com/unveloper/slf4j-timber.git")
	set("PUBLISH_SCM_DEVELOPER_CONNECTION", "scm:git:ssh://github.com/unveloper/slf4j-timber.git")
	set("PUBLISH_SCM_URL", "https://github.com/unveloper/slf4j-timber/tree/master")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

android {
	namespace = "com.spiral_root.android.slf4j_timber"
	compileSdk = libs.versions.compileSdk.get().toInt()
	buildToolsVersion = libs.versions.buildTools.get()

	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
		version = 1
		//versionName = "1.0"

		testInstrumentationRunner = Android.testInstrumentationRunner
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = true
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
		getByName("debug") {
			isMinifyEnabled = false
			isShrinkResources = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		// Sets Java compatibility to Java 1.8
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = libs.versions.appJvmTarget.get()
	}
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	implementation(libs.timber)
	implementation(libs.slf4j)

	testImplementation(libs.bundles.test.common)
}