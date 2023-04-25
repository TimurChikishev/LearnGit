import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

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
        commonMain {
            dependencies {
                api(project(":shared-common-ui"))
                api(project(":shared-common-utils"))
                implementation(project(":shared-core-storage"))
                implementation(project(":shared-core-navigation"))
            }
        }
    }
    addFeatureModules()
}

fun KotlinMultiplatformExtension.addFeatureModules() {

    val featureProjects = rootProject.childProjects
        .filterKeys { name -> name.startsWith(prefix = "shared-feature-") }
        .values
        .flatMap { project -> project.childProjects.values }

    sourceSets {
        commonMain {
            implementations(
                *featureProjects.toTypedArray(),
            )
        }
    }
}

android {
    namespace = "learn.git.shared"
}
