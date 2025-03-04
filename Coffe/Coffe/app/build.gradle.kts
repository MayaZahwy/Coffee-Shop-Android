plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.coffe"
    compileSdk = 35 // update compileSdk to 35 as needed

    defaultConfig {
        applicationId = "com.example.coffe"
        minSdk = 24
        targetSdk = 34  // Keep targetSdk at 34 for now
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11" // Ensure Kotlin target is set to JVM 11
    }

    buildFeatures {
        viewBinding = true
    }

    // Correct packagingOptions syntax for Kotlin DSL
    packagingOptions {
        exclude("META-INF/NOTICE.md")
        exclude("META-INF/LICENSE.md")
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.glide)
    implementation(libs.gson)
    implementation(libs.material.v140)
    // Removed JavaMail dependencies as they are no longer needed
    // implementation(libs.android.mail)
    // implementation(libs.android.activation)
    implementation(libs.kotlinx.coroutines.android)
}
