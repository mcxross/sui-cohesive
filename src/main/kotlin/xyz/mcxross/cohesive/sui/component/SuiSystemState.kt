package xyz.mcxross.cohesive.sui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.mcxross.ksui.client.EndPoint
import xyz.mcxross.ksui.client.createSuiHttpClient
import xyz.mcxross.ksui.model.SuiSystemStateSummary

@Composable
internal fun SuiSystemState() {

  var networkStateModel by remember { mutableStateOf<SuiSystemStateSummary?>(null) }

  LaunchedEffect(Unit) {
    val suiHttpClient = createSuiHttpClient {
      endpoint = EndPoint.MAINNET
      maxRetries = 10
    }
    networkStateModel = suiHttpClient.getLatestSuiSystemState()
  }

  Surface(
      modifier = Modifier.fillMaxWidth().height(400.dp),
      shape = RoundedCornerShape(8.dp),
      contentColor = MaterialTheme.colors.onSurface,
      elevation = 4.dp) {
        Column(modifier = Modifier.fillMaxWidth().background(Color.Black)) {
          Box(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
            Text(
                text = "System State",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium)
          }

          Divider(
              modifier = Modifier.fillMaxWidth(),
              color = MaterialTheme.colors.primary,
              thickness = 1.dp)

          Row(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
            Column(
                modifier =
                    Modifier.width(200.dp).fillMaxHeight().padding(4.dp).background(Color.Red),
                verticalArrangement = Arrangement.Center) {
                  Epoch(modifier = Modifier.fillMaxWidth().height(150.dp).background(Color.Cyan))
                  Text("Epoch count: ", color = Color.White)
                  Text("Started: ", color = Color.White)
                }
            Column(
              modifier = Modifier.fillMaxSize().background(Color.Green)
            ) {
            }
          }
        }
      }
}
