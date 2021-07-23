plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)
    buildToolsVersion(ConfigData.buildToolsVersion)

    defaultConfig {
        applicationId("com.solomaticydl.astronomy")
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)
        versionCode(ConfigData.versionCode)
        versionName(ConfigData.versionName)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Deps.kotlin)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.AndroidX.swipeRefreshLayout)
    implementation(Deps.materialDesign)
    implementation(Deps.Navigation.navigationFragmentKtx)
    implementation(Deps.Navigation.navigationUIKtx)
    implementation(Deps.coroutines)
    implementation(Deps.volley)
    implementation(Deps.moshi)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.AndroidX.testExtJunit)
    androidTestImplementation(Deps.AndroidX.testEspresso)
}