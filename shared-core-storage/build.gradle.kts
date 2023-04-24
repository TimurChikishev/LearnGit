plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            apis(
                Deps.Kmm.Storage.datastore,
            )
        }
    }
}

android {
    namespace = "learn.git.core.storage"
}
