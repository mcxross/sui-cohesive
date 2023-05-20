pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven {
      url = uri(settingsDir.resolve("../.m2/repository"))
    }
  }

  plugins {
    kotlin("jvm").version(extra["kotlin.version"] as String)
    id("org.jetbrains.compose").version(extra["compose.version"] as String)
  }
}

rootProject.name = "sui-cohesive"

include(":sample")

