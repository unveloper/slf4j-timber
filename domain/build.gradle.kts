plugins {
	id(BuildPlugins.javaLibrary)
	id(BuildPlugins.kotlin)
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	// Coroutines
	implementation(libs.kotlin.coroutines.core)
	// Log
	implementation(libs.slf4j)
}