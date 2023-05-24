import xyz.mcxross.cohesive.cgspdp.CohesivePluginExtension

plugins {
  kotlin("jvm") version "1.8.0"
  id("org.jetbrains.compose")
  id("com.google.devtools.ksp") version "1.8.0-1.0.9"
  id("xyz.mcxross.cohesive.cgspdp") version "0.1.0"
}

group = "xyz.mcxross.cohesive.sui"

version = "0.1.0-beta"

repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  dependencies {
    implementation("xyz.mcxross.ksui:ksui-jvm:1.2.0-beta")
    compileOnly(kotlin("stdlib"))
    compileOnly("com.mcxross.cohesive:cohesive-desktop:0.1.0")
    compileOnly("com.mcxross.cohesive:cohesive-csp:0.1.0")
    ksp("com.mcxross.cohesive:cohesive-csp:0.1.0")
  }
  testImplementation(kotlin("test"))
}

configure<CohesivePluginExtension> {
  pluginId.set("xyz.mcxross.cohesive.sui")
  pluginDescription.set("Cohesive Secondary Plugin for Sui")
  pluginRequires.set("2021.2")
  pluginClass.set("xyz.mcxross.cohesive.sui.SuiCohesivePlugin")
  pluginProvider.set("McXross")
  pluginDependencies.set("")
  pluginLicense.set("Apache-2.0")
  pluginVersion.set("0.1.0-beta")
}
