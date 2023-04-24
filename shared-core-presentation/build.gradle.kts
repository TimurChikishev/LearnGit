plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            apis(
                Deps.Kmm.ViewModel.core,
                Deps.Kmm.ViewModel.cFlow,
            )
        }
    }
}

android {
    namespace = "learn.git.core.presentation"
}
