package xyz.mcxross.cohesive.sui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.mcxross.cohesive.sui.theme.blue200
import xyz.mcxross.cohesive.sui.theme.blue400
import xyz.mcxross.cohesive.sui.theme.blue500
import xyz.mcxross.cohesive.sui.theme.card
import xyz.mcxross.cohesive.sui.util.Constants
import xyz.mcxross.cohesive.sui.util.calculateRemainingTime
import xyz.mcxross.cohesive.sui.util.calculateRemainingTime360
import xyz.mcxross.cohesive.sui.util.formatTime
import xyz.mcxross.ksui.client.EndPoint
import xyz.mcxross.ksui.client.createSuiHttpClient
import xyz.mcxross.ksui.model.SuiSystemStateSummary

@Composable
internal fun EpochProgress(progress: Float) {
  Canvas(modifier = Modifier.fillMaxSize()) {
    inset(Constants.TIMER_RADIUS, Constants.TIMER_RADIUS) {
      val gradientBrush = Brush.linearGradient(listOf(blue500, blue200, blue400))
      val strokeWidth = 8.dp.toPx()
      val arcSize = size.minDimension - strokeWidth
      val arcRadius = arcSize / 2
      val arcCenterX = size.width / 2
      val arcCenterY = size.height / 2
      drawArc(
          gradientBrush,
          startAngle = 270f,
          sweepAngle = progress,
          useCenter = false,
          topLeft = Offset(x = arcCenterX - arcRadius, y = arcCenterY - arcRadius),
          style = Stroke(width = 15f, cap = StrokeCap.Round),
          size = androidx.compose.ui.geometry.Size(arcSize, arcSize),
          blendMode = BlendMode.SrcIn)
      drawCircle(
          color = card,
          radius = 0.49f * minOf(size.width, size.height),
          center = center,
      )
    }
  }
}

@Composable
fun EpochProgressText(remainingTime: String) {
  Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
    Text(
        text = remainingTime,
        fontSize = 12.sp,
        color = Color.White,
        style = MaterialTheme.typography.subtitle1)
  }
}

@Composable
fun Epoch(modifier: Modifier = Modifier) {

  Box(modifier = modifier, contentAlignment = Alignment.Center) {
    EpochProgress(180f)
    EpochProgressText("2:40")
  }
}
