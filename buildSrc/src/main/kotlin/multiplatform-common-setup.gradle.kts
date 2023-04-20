import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

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
                api(Deps.Kmm.Resources.core)
                implementation(compose.runtime)
                implementation(compose.material3)
                implementation(compose.foundation)
                implementation(Deps.Logging.napier)
                implementation(Deps.Koin.core)
                implementation(Deps.Decompose.core)
                implementation(Deps.Kmm.collections)
                implementation(Deps.Kotlin.Coroutines.core)
                implementation(Deps.MVI.main)
                implementation(Deps.MVI.core)
                implementation(Deps.MVI.logging)
                implementation(Deps.MVI.coroutines)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Deps.Koin.android)
                api(Deps.AndroidX.ktx)
                api(Deps.AndroidX.appcompat)
                api(Deps.AndroidX.Compose.activity)
                api(Deps.Kmm.Resources.android)
                implementation(Deps.Koin.compose)
                implementation(Deps.Decompose.android)
                implementation(Deps.Decompose.compose)
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
                implementation(compose.desktop.common)
                implementation(Deps.Koin.compose)
                implementation(Deps.Decompose.compose)
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
