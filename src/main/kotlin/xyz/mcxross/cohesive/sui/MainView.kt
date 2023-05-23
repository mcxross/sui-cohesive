package xyz.mcxross.cohesive.sui

import androidx.compose.runtime.Composable
import com.mcxross.cohesive.common.frontend.api.ui.view.CohesiveView
import com.mcxross.cohesive.csp.annotation.Cohesive
import com.mcxross.cohesive.csp.annotation.Net

/**
 * Default implementation of [CohesiveView] that is used when no other implementation is provided.
 *
 * It implements all abstract methods of [CohesiveView] with "generic" UIs.
 * @since 0.1.0
 */
@Cohesive(
  platform = "Sui",
  version = "0.1.0-beta",
  nets =
    [
      Net(
        k = "Mainnet",
        v = "https://fullnode.mainnet.sui.io",
      ),
      Net(
        k = "Testnet",
        v = "https://fullnode.testnet.sui.io",
      ),
      Net(
        k = "Localhost",
        v = "http://localhost:9000",
      ),
    ],
)
open class MainView : CohesiveView {

  @Composable
  override fun Explorer() {
    xyz.mcxross.cohesive.sui.view.Explorer()
  }

  @Composable
  override fun Wallet() {
    xyz.mcxross.cohesive.sui.view.Wallet()
  }
}
