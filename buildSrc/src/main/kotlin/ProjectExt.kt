import com.android.build.gradle.LibraryExtension
import java.io.File
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

// Build Info
object Build {
    fun getVersionName(project: Project): String {
        return "1.0.${gitCommitCount(project)}"
    }

    fun getVersionCode(project: Project): Int = gitCommitCount(project)

    private fun gitCommitCount(project: Project): Int {
        return ("git rev-list --count HEAD".execute(project.rootDir, "1").toInt())
    }
}

private fun String?.letIfEmpty(fallback: String): String {
    return if (this == null || isEmpty()) {
        fallback
    } else {
        this
    }
}

private fun String?.execute(workingDir: File, fallback: String): String {
    Runtime.getRuntime().exec(this, null, workingDir).let {
        it.waitFor()
        return try {
            it.inputStream.reader().readText().trim().letIfEmpty(fallback)
        } catch (e: Exception) {
            fallback
        }
    }
}

// Project
internal fun Project.android(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

internal fun Project.`kotlin`(configure: Action<KotlinMultiplatformExtension>): Unit =
    (this as ExtensionAware).extensions.configure("kotlin", configure)

// Targets
fun KotlinMultiplatformExtension.`sourceSets`(configure: Action<NamedDomainObjectContainer<KotlinSourceSet>>): Unit =
    (this as ExtensionAware).extensions.configure("sourceSets", configure)

val NamedDomainObjectContainer<KotlinSourceSet>.`commonMain`: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named<KotlinSourceSet>("commonMain")

val NamedDomainObjectContainer<KotlinSourceSet>.`desktopMain`: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named<KotlinSourceSet>("desktopMain")

val NamedDomainObjectContainer<KotlinSourceSet>.`androidMain`: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named<KotlinSourceSet>("androidMain")

// Dependecies
private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.implementation(
    dependencyNotation: String,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    dependencies = this,
    configuration = "implementation",
    dependencyNotation = dependencyNotation,
    configurationAction = dependencyConfiguration
)

fun KotlinSourceSet.implementations(
    vararg dependecies: Any,
) = dependencies {
    dependecies.forEach(::implementation)
}

fun KotlinSourceSet.apis(
    vararg dependecies: Any,
) = dependencies {
    dependecies.forEach(::api)
}
