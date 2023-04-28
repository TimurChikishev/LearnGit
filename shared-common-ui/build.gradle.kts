plugins {
    id("multiplatform-common-setup")
}

kotlin {
    sourceSets {
        commonMain {
            apis(
                project(":shared-common-res"),
            )
            implementations(
                Deps.Kmm.ViewModel.core,
                Deps.Kmm.ViewModel.cFlow,
            )
        }
        androidMain {
            implementations(
                Deps.AndroidX.Compose.Accompanist.systemUiController,
            )
        }
    }
}

android {
    namespace = "learn.git.common.ui"
}
