import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.mcxross.cohesive.sui.component.Epoch
import xyz.mcxross.cohesive.sui.view.Explorer

fun main() = application { Window(onCloseRequest = ::exitApplication) { Explorer() } }
