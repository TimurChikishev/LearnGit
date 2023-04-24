plugins {
    id("multiplatform-feature-setup")
}

kotlin {
    sourceSets {
        commonMain {
            implementations(
                project(":shared-core-storage")
            )
        }
    }
}

android {
    namespace = "learn.git.feature.onboarding.data"
}
