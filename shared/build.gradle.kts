plugins {
    id("multiplatform-common-setup")
    kotlin("plugin.serialization")
    kotlin("native.cocoapods")
    id("kotlin-parcelize")
}

version = Versions.Ios.podVersion

kotlin {
    cocoapods {
        summary = "Shared code for LearnGitBranching"
        homepage = "https://github.com/TimurChikishev/LearnGit"
        ios.deploymentTarget = Versions.Ios.deploymentTarget
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            export(project(":shared-common-ui"))
            export(Deps.Kmm.Resources.core)
            export(Deps.Kmm.Decompose.core)
            export(Deps.Kmm.Essenty.lifecycle)
            export(Deps.Kmm.Essenty.stateKeeper)
            isStatic = true
        }
        noPodspec()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared-common-ui"))
                api(project(":shared-common-utils"))
                implementation(project(":shared-core-navigation"))
                implementation(project(":shared-feature-splash:ui"))
                implementation(project(":shared-feature-onboarding:ui"))
            }
        }
    }
}

android {
    namespace = "learn.git.shared"
}
