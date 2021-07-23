object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val volley = "com.android.volley:volley:${Versions.volley}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val junit = "junit:junit:${Versions.junit}"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
        const val testExtJunit = "androidx.test.ext:junit:${Versions.androidXTestExtJunit}"
        const val testEspresso =
            "androidx.test.espresso:espresso-core:${Versions.androidXTestEspresso}"
    }

    object Navigation {
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }
}