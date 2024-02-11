
plugins {
    id(Dependencies.Plugins.android_application)
    id(Dependencies.Plugins.kotlin_android)
    id(Dependencies.Plugins.ksp)
}

android {
    namespace = Dependencies.Application.appId
    compileSdk = Dependencies.Versions.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.minsdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = Dependencies.Application.releaseMinify

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            isMinifyEnabled = Dependencies.Application.debugMinify

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.kotlinCompiler
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = Dependencies.Java.java_compile
        targetCompatibility = Dependencies.Java.java_compile
    }
    kotlinOptions {
        jvmTarget = Dependencies.Java.java_versions
    }
}

dependencies {
    implementation(platform(Dependencies.Compose.composeBoom))
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Dependencies.android_core_ktx)
    implementation(Dependencies.Dependencies.lifecycle_runtime)
    implementation(Dependencies.Dependencies.material)
    implementation(Dependencies.Compose.activityCompose)
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composeFoundation)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.compose_permissions)
    implementation(Dependencies.Dependencies.window)
    implementation(Dependencies.Compose.fullSetIconsCompose)
    implementation(Dependencies.Compose.lottie)

    //koin
    implementation(Dependencies.Dependencies.koin_android)
    implementation(Dependencies.Dependencies.koin_compose)

    //room
    implementation(Dependencies.Dependencies.room_runtime)
    implementation(Dependencies.Dependencies.room_ktx)
    ksp(Dependencies.AnnotationProcessing.room_compiler)

    implementation (Dependencies.Compose.calendar)
    coreLibraryDesugaring(Dependencies.Java.desugaring)
}