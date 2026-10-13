package mx.edu.utez.liverpool_axel.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_axel.model.Comentario

@Composable
fun ComentarioList(
    comentarios: List<Comentario>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Opiniones de clientes",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                if (comentarios.isNotEmpty()) {
                    comentarios.forEachIndexed { index, comentario ->
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = comentario.usuario,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF212121),
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            RatingBar(
                                rating = comentario.calificacion,
                                starSize = 14.dp
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "\"${comentario.texto}\"",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.DarkGray
                            )
                        }
                        if (index < comentarios.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 12.dp),
                                color = Color(0xFFE5E5EA),
                            )
                        }
                    }
                } else {
                    Text(
                        text = "Este producto aún no tiene comentarios",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}