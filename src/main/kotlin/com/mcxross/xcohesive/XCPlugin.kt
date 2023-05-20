package com.mcxross.xcohesive

import com.mcxross.cohesive.cps.Plugin
import com.mcxross.cohesive.cps.PluginWrapper

class XCPlugin(pluginWrapper : PluginWrapper) : Plugin(pluginWrapper) {
  override fun start() {
   // Plugin is started
  }

  override fun stop() {
    // Plugin is stopped
  }

  override fun uninstall() {
    // Plugin is uninstalled
  }

}
