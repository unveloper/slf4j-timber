# slf4j-timber

This is a library that allows pure Java / Kotlin modules or libraries using [SLF4J](https://www.slf4j.org/) as their logging framework to bridge on the Google Android platform
in combination with [Jake Wharton's Timber logging utility](https://github.com/JakeWharton/timber).

It's based on the [patrickfav/slf4j-timber](https://github.com/patrickfav/slf4j-timber) project with a modern take 
using Kotlin and the latest version of _SLF4J_ (currently **v2.0.0**).

Usage
-----

Follow the guidelines from [jitpack.io](https://jitpack.io) to add the JitPack repository to your build file if you have not.

Typically, this means an edit to your `settings.gradle.kts` file to add a new `repository` definition in the `repositories` block, like this:

```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()

		maven("https://jitpack.io")
	}
}
```

Then add the _slf4j-timber_ artifact from this repository as a dependency in your `app` module:

```gradle
dependencies {
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.github.unveloper:slf4j-timber:0.0.2")
}
```

In the pure Java / Kotlin modules should be present the _SLF4J_ artifact:

```gradle
dependencies {
    implementation("org.slf4j:slf4j-api:2.0.0")
}
```

And that's basically it. SLF4J will automatically look for implementations of `ILoggerFactory` in the classpath (so don't add this
parallel to `org.slf4j:slf4j-android`)

Check out the [source code](https://github.com/unveloper/slf4j-timber/tree/master/app) to see an example app.

## Description

### Log level mapping
The priorities will be converted to LogCat's priority level and passed to
`Timber.log(...);`. The `Log.isLoggable()` are not respected here, since `Timber`
should be responsible to decide when to log what. The following table shows
the mapping from SLF4J log levels to LogCat log levels.

| SLF4J         | Android/Timber |
| ------------- |:-------------: |
| TRACE         | VERBOSE        |
| DEBUG         | DEBUG          |
| INFO          | INFO           |
| WARN          | WARN           |
| ERROR         | ERROR          |

### Logger name mapping

Logger instances created using the LoggerFactory are named either according to the name given as parameter, or the fully qualified class name of the class given as
parameter. No truncating will take place since Timber handles this itself.

### Limitations

The Android-Timber binding implementation currently does not support Markers.
All logging methods which have a Marker parameter simply delegate to the corresponding method without a Marker parameter, i.e., the Marker parameter
is silently ignored.

License
-------

    Copyright (C) 2015-2022 unveloper
    Copyright (C) 2005-2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.