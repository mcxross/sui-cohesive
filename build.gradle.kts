plugins {
  kotlin("jvm") version "1.8.0"
  id("org.jetbrains.compose")
}

group = "xyz.mcxross.cohesive.sui"

version = "0.1.0-beta"

repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  implementation("xyz.mcxross.ksui:ksui-jvm:1.2.0-beta")
  compileOnly("com.mcxross.cohesive:cohesive-desktop:0.1.0")
  compileOnly(compose.desktop.currentOs)
}
