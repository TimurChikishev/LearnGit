object Versions {

    object Android {
        const val compileSdk = 33
        const val targetSdk = compileSdk
        const val minSdk = 24
    }

    object Ios {
        const val podVersion = "1.0-SNAPSHOT"

        const val deploymentTarget = "14.1"
    }

    const val kotlinVersion = "1.8.20"
}

object Deps {

    object Kotlin {

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

        object Detekt {
            const val version = "1.22.0"
            const val pluginName = "io.gitlab.arturbosch.detekt"
            const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"

            const val composeKodeRules = "ru.kode:detekt-rules-compose:1.2.2"
            const val composeTwitterRules = "com.twitter.compose.rules:detekt:0.0.26"
        }

        object Serialization {
            const val plugin = "plugin.serialization"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0"
        }

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val coreIos = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-Beta"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val swing = "org.jetbrains.kotlinx:kotlinx-coroutines-swing:$version"
        }
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.3.1"
        const val jdkDesugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

        object Debug {
            const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.7"
        }
    }

    object AndroidX {
        const val ktx = "androidx.core:core-ktx:1.10.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"

        object Compose {
            const val activity = "androidx.activity:activity-compose:1.7.0"

            object Accompanist {
                private const val accompanistVersion = "0.29.0-alpha"

                const val systemUiController =
                    "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"
            }
        }
    }

    object Kmm {
        const val parcelize = "dev.icerock.moko:parcelize:0.7.1"
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
        const val collections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"

        object ViewModel {
            private const val version = "0.15.0"
            const val core = "dev.icerock.moko:mvvm-core:$version"
            const val cFlow = "dev.icerock.moko:mvvm-flow:$version"
        }

        object Resources {
            private const val version = "0.20.1"
            const val core = "dev.icerock.moko:resources:$version"
            const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
            const val android = "dev.icerock.moko:resources-compose:$version"
        }

        object Colors {
            private const val version = "0.9.0"
            const val core = "dev.icerock.moko:graphics:$version"
        }

        object Images {
            private const val version = "1.1.4"
            const val gradlePlugin = "io.github.skeptick.libres:gradle-plugin:$version"
            const val compose = "io.github.skeptick.libres:libres-compose:$version"
        }
    }

    object Decompose {
        private const val version = "2.0.0-alpha-02"
        const val core = "com.arkivanov.decompose:decompose:$version"
        const val compose = "com.arkivanov.decompose:extensions-compose-jetbrains:$version"
        const val android = "com.arkivanov.decompose:extensions-android:$version"
    }

    object Koin {
        private const val version = "3.3.3"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:3.4.2"
    }

    object Logging {
        const val napier = "io.github.aakira:napier:2.6.1"
    }

    object MVI {
        private const val version = "3.0.2"
        const val core = "com.arkivanov.mvikotlin:mvikotlin:$version"
        const val main = "com.arkivanov.mvikotlin:mvikotlin-main:$version"
        const val logging = "com.arkivanov.mvikotlin:mvikotlin-logging:$version"
        const val coroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$version"
    }

    object BuildKonfig {
        private const val version = "0.11.0"
        const val gradlePlugin = "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:$version"
    }
}
