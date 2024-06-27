package com.example.noteapp.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FilterChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val borderColor = MaterialTheme.colorScheme.onSurface
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }
    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSecondaryContainer
    }

    val path = remember { Path() }
    val borderWidth = with(LocalDensity.current) { 2.dp.toPx() }

    val pathMeasure = remember { PathMeasure() }
    val pathSegment = remember { Path() }
    val transition = updateTransition(targetState = isSelected, label = "transition")
    val pathFraction by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300, easing = FastOutSlowInEasing) },
        label = "pathSegment"
    ) { selected ->
        if (selected) 1f else 0f
    }

    Box(
        modifier =
        modifier
            .clip(shape = RoundedCornerShape(percent = 100))
            .background(backgroundColor)
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .drawWithCache {
                val cornerRadius = size.height / 2f
                path.moveTo(borderWidth + size.width / 2f, borderWidth)
                path.lineTo(size.width - borderWidth - cornerRadius, borderWidth)
                path.quadraticBezierTo(
                    size.width - borderWidth,
                    borderWidth,
                    size.width - borderWidth,
                    borderWidth + cornerRadius
                )
                path.quadraticBezierTo(
                    size.width - borderWidth,
                    size.height - borderWidth,
                    size.width - borderWidth - cornerRadius,
                    size.height - borderWidth
                )
                path.lineTo(borderWidth + cornerRadius, size.height - borderWidth)
                path.quadraticBezierTo(
                    borderWidth,
                    size.height - borderWidth,
                    borderWidth,
                    size.height - cornerRadius - borderWidth
                )
                path.quadraticBezierTo(
                    borderWidth,
                    borderWidth,
                    borderWidth + cornerRadius,
                    borderWidth
                )
                path.close()
                onDrawBehind {
                    drawPath(
                        path = path,
                        color = backgroundColor,
                        style = Fill,
                    )
                    if (isSelected) {
                        drawPath(
                            path = path,
                            color = borderColor,
                            style = Stroke(width = borderWidth),
                        )
                    }
                }
            }
    ) {
        Text(
            label,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}