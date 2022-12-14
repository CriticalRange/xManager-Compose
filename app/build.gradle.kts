plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.7.20"
    id("kotlin-parcelize")
}

android {
    namespace = "dev.ushiekane.xmanager"
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.ushiekane.xmanager"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "0.0.1"

        vectorDrawables.useSupportLibrary = true
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
        jvmTarget = "11"
    }

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.3.0-rc02"

}

dependencies {
    // AndroidX core
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.core:core-splashscreen:1.0.0")

    implementation("androidx.activity:activity-compose:1.7.0-alpha02")

    val composeVersion = "1.3.0-alpha03"
    implementation("androidx.compose.ui:ui:${composeVersion}")
    implementation("androidx.compose.material3:material3:1.1.0-alpha01")
    implementation("androidx.compose.material:material-icons-extended:${composeVersion}")

    // Accompanist
    val accompanistVersion = "0.26.0-alpha"
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

    // Taxi (navigation)
    implementation("com.github.X1nto:Taxi:1.2.0")

    // Koin
    val koinVersion = "3.2.2"
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:3.2.1")

    // KotlinX
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

    // Networking
    implementation("com.vk.knet:core:1.0")
    implementation("com.vk.knet:cronet:1.0")
    implementation("com.vk.knet:okcronet:1.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    debugImplementation("androidx.compose.ui:ui-tooling:${composeVersion}")
    implementation("androidx.compose.material3:material3:1.1.0-alpha01")
    implementation("androidx.compose.material:material-icons-extended:${composeVersion}")
    implementation("androidx.core:core-splashscreen:1.0.0")
}