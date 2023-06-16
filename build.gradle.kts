plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("io.gitlab.arturbosch.detekt") version "1.23.0" apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
    }
}
