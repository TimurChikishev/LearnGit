import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") apply false
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    id(Deps.Kotlin.Detekt.pluginName).version(Deps.Kotlin.Detekt.version)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    buildscript {
        dependencies {
            classpath(Deps.Kotlin.gradlePlugin)
            classpath(Deps.Android.gradlePlugin)
            classpath(Deps.Kmm.BuildKonfig.gradlePlugin)
            classpath(Deps.Kmm.Resources.gradlePlugin)
        }
    }
}

apply(from = "$rootDir/buildSrc/lintConfiguration.gradle")

dependencies {
    detektPlugins(Deps.Kotlin.Detekt.formatting)
    detektPlugins(Deps.Kotlin.Detekt.composeKodeRules)
    detektPlugins(Deps.Kotlin.Detekt.composeTwitterRules)
}

detekt {
    disableDefaultRuleSets = true
    buildUponDefaultConfig = true
    autoCorrect = true
    description = "Detekt with formatting."
    config = files("$rootDir/linters/detekt/config.yml")
}

tasks.withType<Detekt>().configureEach {
    setupDetektFolders()
    setupDetektReports()
}

fun Detekt.setupDetektFolders() {
    setSource(files(projectDir))
    include("**/*.kt")
    include("**/*.kts")
    exclude("**/resources/**")
    exclude("**/build/**")
    exclude("**/.gradle/**")
}

fun Detekt.setupDetektReports() {
    reports {
        html {
            required.set(true)
            outputLocation.set(file("$rootDir/build/reports/detekt/detekt.html"))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

val changeGitHooksDir by tasks.registering(Exec::class) {
    group = "git"
    description = "Changing githooks dir to .githooks"

    fun ExecSpec.executeStringCommand(command: String) {
        val splitted = command.split(" ")
        commandLine(*splitted.toTypedArray())
    }

    fun execute(command: String) {
        exec { executeStringCommand(command) }
    }

    doFirst {
        logger.error("hooksPath before")
        execute("git config core.hooksPath 2>&1")
    }

    executeStringCommand("git config core.hooksPath .githooks")

    doLast {
        logger.error("hooksPath after")
        execute("git config core.hooksPath")
    }

    onlyIf {
        System.getenv("IS_CI") == null
    }
}
