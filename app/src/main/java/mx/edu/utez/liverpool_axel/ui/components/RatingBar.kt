package mx.edu.utez.liverpool_axel.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_axel.model.Comentario
import java.util.Locale

@Composable
fun RatingBar(
    rating: Float,
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
    starSize: Dp = 18.dp,
    starColor: Color = Color(0xFFFFB800),
    emptyColor: Color = Color(0xFFD6D6D6),
    spaceBetween: Dp = 2.dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        for (i in 1..maxStars) {
            val icon = when {
                rating >= i -> Icons.Filled.Star
                rating >= i - 0.5f -> Icons.AutoMirrored.Filled.StarHalf
                else -> Icons.Filled.Star
            }
            val tint = if (rating >= i - 0.5f) starColor else emptyColor

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(starSize)
            )
        }
    }
}

@Composable
fun ProductoRatingBar(
    comentarios: List<Comentario>,
    defaultRating: Float = 0f,
    reviewCount: Int = 0,
    modifier: Modifier = Modifier,
    starSize: Dp = 18.dp
) {
    val promedio = remember(comentarios, defaultRating) {
        if (comentarios.isNotEmpty()) {
            comentarios.map { it.calificacion }.average().toFloat()
        } else {
            defaultRating
        }
    }

    val totalOpiniones = if (comentarios.isNotEmpty()) {
        comentarios.size
    } else {
        reviewCount
    }

    val promedioFormateado = String.format(Locale.US, "%.1f", promedio)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RatingBar(
            rating = promedio,
            starSize = starSize
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = promedioFormateado,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.width(6.dp))

    }
}
