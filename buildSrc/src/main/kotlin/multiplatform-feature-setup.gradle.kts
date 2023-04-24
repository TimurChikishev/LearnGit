plugins {
    id("multiplatform-setup")
}

kotlin {
    val commonProjects = when {
        project.isUiModule -> listOf(
            project(":shared-core-presentation"),
            project(":shared-core-navigation"),
            project(":shared-common-ui"),
        )
        project.isPresentationModule -> listOf(
            project(":shared-core-presentation"),
            project(":shared-core-navigation"),
        )
        else -> emptyList()
    }

    val childProjectsValues = project.parent?.childProjects?.values?.filter { it != project }
    val featureProjects = when {
        project.isUiModule -> childProjectsValues?.filter { it.isPresentationModule || it.isApiModule }
        project.isPresentationModule || project.isDomainModule || project.isDataModule -> {
            childProjectsValues?.filter { it.isApiModule }
        }

        else -> null
    }.orEmpty()

    sourceSets {
        commonMain {
            implementations(
                *commonProjects.plus(featureProjects).toTypedArray(),
            )
        }
    }
}
