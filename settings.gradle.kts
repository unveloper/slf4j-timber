pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()

		maven("https://jitpack.io")
	}
}
rootProject.name = "slf4j-timber"

include(":app")
include(":slf4j-timber")
include(":data")
