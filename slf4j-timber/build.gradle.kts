plugins {
	id(BuildPlugins.androidLibrary)
	id(BuildPlugins.kotlinAndroid)
	id(BuildPlugins.mavenPublish)
}

android {
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

afterEvaluate {
	publishing {
		publications {
			register("release", MavenPublication::class) {
				from(components.getByName("release"))
				groupId = "com.github.unveloper"
				artifactId = "slf4j-timber"
				version = "0.0.2"
			}
		}
	}
}

dependencies {
	implementation(libs.timber)
	implementation(libs.slf4j)

	testImplementation(libs.bundles.test.common)
}