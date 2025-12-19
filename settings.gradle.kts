pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "ardacrepo"

include("HDFilmCehennemi", "SelcukFlix")

include(":HDFilmCehennemi")
include(":SelcukFlix")