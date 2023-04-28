plugins {
    id("multiplatform-feature-setup")
}

kotlin {
    sourceSets {
        commonMain {
            implementations(
                project(":shared-common-res")
            )
        }
    }
}

android {
    namespace = "learn.git.common.data"
}
