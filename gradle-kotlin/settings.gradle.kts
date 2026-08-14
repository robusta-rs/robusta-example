pluginManagement {
    val robustaPluginBuild = providers.gradleProperty("robustaPluginBuild")

    if (robustaPluginBuild.isPresent) {
        includeBuild(robustaPluginBuild.get())
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "robusta-gradle-kotlin-example"
