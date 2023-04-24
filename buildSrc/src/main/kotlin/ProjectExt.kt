import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.named
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import java.io.File

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

val KotlinMultiplatformExtension.`compose`: ComposePlugin.Dependencies get() =
    (this as ExtensionAware).extensions.getByName("compose") as ComposePlugin.Dependencies

fun KotlinMultiplatformExtension.`compose`(configure: Action<ComposePlugin.Dependencies>): Unit =
    (this as ExtensionAware).extensions.configure("compose", configure)

// Feature
enum class FeatureModuleType {
    API,
    UI,
    DATA,
    DOMAIN,
    PRESENTATION;

    val actualName get() = name.toLowerCase()

    fun list() = values().map { it.name.toLowerCase() }
}

val Project.isUiModule
    get() = (name == FeatureModuleType.UI.actualName)

val Project.isApiModule
    get() = (name == FeatureModuleType.API.actualName)

val Project.isDataModule
    get() = (name == FeatureModuleType.DATA.actualName)

val Project.isDomainModule
    get() = (name == FeatureModuleType.DOMAIN.actualName)

val Project.isPresentationModule
    get() = (name == FeatureModuleType.PRESENTATION.actualName)
