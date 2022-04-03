package info.justinthought.redactable

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

fun Modifier.redactable(
    redaction: Redaction = Redaction.PLACEHOLDER,
    color: Color = Color.LightGray.copy(alpha = 0.5f)
) = composed {
    if (LocalRedaction.current || redaction == Redaction.FORCE) {
        when (redaction) {
            Redaction.FORCE,
            Redaction.PLACEHOLDER -> {
                var targetValue by remember { mutableStateOf(1f) }
                val animationProgress by animateFloatAsState(
                    targetValue = targetValue, animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 800),
                        repeatMode = RepeatMode.Reverse
                    )
                )

                SideEffect {
                    targetValue = 0.2f
                }

                drawWithContent {
                    drawRoundRect(
                        alpha = animationProgress,
                        color = color,
                        cornerRadius = CornerRadius(8.0f, 8.0f),
                        size = this.size.times(0.8f)
                    )
                }
            }
            Redaction.HIDDEN -> this.alpha(0.0f)
        }
    } else
        this
}