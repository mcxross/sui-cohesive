package xyz.mcxross.cohesive.sui.view

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.mcxross.cohesive.sui.component.SuiSystemState
import xyz.mcxross.cohesive.sui.pxToDp

@Composable
internal fun BackLayer(
    isOpen: Boolean,
) {

  var isContentVisible by remember { mutableStateOf(isOpen) }
  var rotationState by remember { mutableStateOf(0f) }

  LaunchedEffect(isOpen) {
    isContentVisible = isOpen
    rotationState = if (isOpen) 180f else 0f
  }

  Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.background(MaterialTheme.colors.background).padding(16.dp)) {
        Text(text = "Explorer", style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Toggle Button",
            tint = Color.Black,
            modifier = Modifier.rotate(rotationState).alpha(if (isOpen) 1f else 0.5f))
      }
}

@Composable
internal fun FrontLayer() {
  Surface(
      elevation = 5.dp,
      modifier =
          Modifier.fillMaxSize().clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))) {
        Box(Modifier.padding(start = 12.dp, top = 2.dp, end = 12.dp).fillMaxSize()) {
          val stateVertical = rememberScrollState(0)
          Box(
              modifier =
                  Modifier.padding(start = 30.dp, end = 30.dp)
                      .fillMaxSize()
                      .verticalScroll(stateVertical)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)) {
                      SuiSystemState()
                      BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                        var maxWidth by remember { mutableStateOf(maxWidth.value) }

                        Row(
                            modifier =
                                Modifier.fillMaxWidth().onSizeChanged {
                                  maxWidth = it.width.toFloat()
                                },
                            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                              Card(
                                  modifier =
                                      Modifier.size(
                                          (maxWidth.toInt().pxToDp() - 16.dp) * 0.25f, 300.dp)) {}
                              Card(
                                  modifier =
                                      Modifier.size(
                                          (maxWidth.toInt().pxToDp() - 16.dp) * 0.5f, 300.dp)) {}
                              Card(
                                  modifier =
                                      Modifier.size(
                                          (maxWidth.toInt().pxToDp() - 16.dp) * 0.25f, 300.dp)) {}
                            }
                      }

                      Column(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
                          Text(
                              text = "Transaction Blocks",
                              fontSize = 18.sp,
                              fontWeight = FontWeight.Medium)
                        }

                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colors.background,
                            thickness = 1.dp)
                        Box(modifier = Modifier) {
                          Column(Modifier) { repeat(100) { Text(it.toString()) } }
                        }
                      }
                    }
              }

          VerticalScrollbar(
              modifier = Modifier.padding(end = 3.dp).align(Alignment.CenterEnd).fillMaxHeight(),
              adapter = rememberScrollbarAdapter(stateVertical))
        }
      }
}

@Composable
internal fun PseudoBackdrop(
    isOpen: Boolean = false,
) {

  Column(Modifier.fillMaxSize()) {
    BackLayer(isOpen)
    FrontLayer()
  }
}

@Composable
fun Explorer() {
  PseudoBackdrop()
}
