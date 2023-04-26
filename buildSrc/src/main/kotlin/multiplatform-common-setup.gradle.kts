plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm("desktop")
    ios()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(Deps.Kmm.Decompose.core)
                api(Deps.Kmm.Resources.core)
                implementation(compose.runtime)
                implementation(compose.material3)
                implementation(compose.foundation)
                implementation(Deps.Kmm.Decompose.compose)
                implementation(Deps.Kmm.Logging.napier)
                implementation(Deps.Kmm.Koin.core)
                implementation(Deps.Kmm.Decompose.core)
                implementation(Deps.Kmm.collections)
                implementation(Deps.Kotlin.Coroutines.core)
                implementation(Deps.Kmm.MVI.main)
                implementation(Deps.Kmm.MVI.core)
                implementation(Deps.Kmm.MVI.logging)
                implementation(Deps.Kmm.MVI.coroutines)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Deps.Kmm.Koin.android)
                api(Deps.AndroidX.ktx)
                api(Deps.AndroidX.appcompat)
                api(Deps.AndroidX.Compose.activity)
                api(Deps.Kmm.Resources.compose)
                implementation(Deps.Kmm.Koin.compose)
                implementation(Deps.Kmm.Decompose.android)
                implementation(Deps.Kotlin.Coroutines.android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Deps.Kotlin.Coroutines.coreIos)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val desktopMain by getting {
            dependencies {
                api(Deps.Kmm.Resources.compose)
                implementation(compose.desktop.common)
                implementation(Deps.Kmm.Koin.compose)
                implementation(Deps.Kotlin.Coroutines.swing)
            }
        }
    }
}

android {
    compileSdk = Versions.Android.compileSdk
    defaultConfig {
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs(
            File(buildDir, "src/androidMain/res"),
            File(buildDir, "generated/moko/androidMain/res")
        )
    }
}
