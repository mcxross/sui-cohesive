import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

group = "xyz.mcxross.cohesive.sui.sample"

version = "1.0-SNAPSHOT"

repositories {
  google()
  mavenCentral()
  mavenLocal()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
  jvm {
    jvmToolchain(11)
    withJava()
  }
  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation(compose.desktop.currentOs)
        implementation("com.mcxross.cohesive:cohesive-desktop:0.1.0")
      }
    }
    val jvmTest by getting
  }
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "sample"
      packageVersion = "1.0.0"
    }
  }
}
