plugins {
    id("dev.icerock.mobile.multiplatform-resources")
    id("multiplatform-common-setup")
    kotlin("native.cocoapods")
}

version = Versions.Ios.podVersion

multiplatformResources {
    multiplatformResourcesPackage = "learn.git.res"
    iosBaseLocalizationRegion = "en"
    disableStaticFrameworkWarning = true
}

kotlin {
    cocoapods {
        framework {
            export(Deps.Kmm.Resources.core)
            isStatic = true
        }
        extraSpecAttributes["resources"] =
            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }
    sourceSets {
        commonMain {
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
