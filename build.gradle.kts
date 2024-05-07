// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}
buildscript {
    repositories{
        google()
        mavenCentral()
        // Configure the Maven repository address for the HMS Core SDK.
        maven(url = "https://developer.huawei.com/repo/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
    }
}

