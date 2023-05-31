package xyz.mcxross.cohesive.sui.util

import java.text.SimpleDateFormat
import java.util.*

fun formatTime(timeInMillis: Long): String {
  val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
  val date = Date(timeInMillis)
  return format.format(date)
}
fun calculateRemainingTime(epochStartTimestampMs: Long, epochDurationMs: Long): Long {
  val currentTimeMs = System.currentTimeMillis()
  val elapsedTimeMs = currentTimeMs - epochStartTimestampMs
  return epochDurationMs - elapsedTimeMs
}
fun calculateRemainingTime360(epochStartTimestampMs: Long, epochDurationMs: Long): Float {
  val currentTimeMs = System.currentTimeMillis()
  val elapsedTimeMs = currentTimeMs - epochStartTimestampMs
  val remainingTimeMs = epochDurationMs - elapsedTimeMs

  // Ensure the remaining time is within the epoch duration
  val clampedRemainingTimeMs = remainingTimeMs.coerceIn(0, epochDurationMs)

  // Convert the remaining time to a value between 0 and 360

  return clampedRemainingTimeMs.toFloat() / epochDurationMs.toFloat() * 360f
}
