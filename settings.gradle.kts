pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NutriScan"

include(":app")
include(":core:common")
include(":core:design")
include(":core:database")
include(":core:network")
include(":feature:home")
include(":feature:search")
include(":feature:diary")
include(":feature:scanner")
include(":feature:profile")
