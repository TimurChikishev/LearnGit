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
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] =
            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared-common-ui"))
                implementation(project(":shared-core-navigation"))
            }
        }
    }
}

android {
    namespace = "learn.git.shared"
}
