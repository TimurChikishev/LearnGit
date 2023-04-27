pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        id("com.android.base").version(agpVersion)
        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)
        id("org.jetbrains.compose").version(composeVersion)
    }
}

rootProject.name = "LearnGitBranching"

include(":androidApp")
include(":desktopApp")

include(":shared")
include(":shared-common-ui")
include(":shared-common-res")
include(":shared-common-data")
include(":shared-common-utils")
include(":shared-core-storage")
include(":shared-core-navigation")
include(":shared-core-presentation")

include(":shared-feature-splash:api")
include(":shared-feature-splash:data")
include(":shared-feature-splash:domain")
include(":shared-feature-splash:presentation")
include(":shared-feature-splash:ui")

include(":shared-feature-onboarding:api")
include(":shared-feature-onboarding:data")
include(":shared-feature-onboarding:domain")
include(":shared-feature-onboarding:presentation")
include(":shared-feature-onboarding:ui")

include(":shared-feature-levels:api")
include(":shared-feature-levels:data")
include(":shared-feature-levels:domain")
include(":shared-feature-levels:presentation")
include(":shared-feature-levels:ui")

include(":shared-feature-settings:ui")

include(":shared-feature-lessons:api")
include(":shared-feature-lessons:data")
include(":shared-feature-lessons:domain")
include(":shared-feature-lessons:presentation")
include(":shared-feature-lessons:ui")
