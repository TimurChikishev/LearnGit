plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            implementations(
                project(":shared-common-ui"),
                project(":shared-core-navigation"),
            )
        }
    }
}
