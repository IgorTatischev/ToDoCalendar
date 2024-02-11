buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Plugins.android_build_gradle)
        classpath(Dependencies.Plugins.kotlin_version)
    }
}
plugins {
    id(Dependencies.Plugins.ksp) version ("1.8.10-1.0.9") apply false
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
