package mx.edu.utez.liverpool_axel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_axel.model.ProductoDetalle
import java.util.Locale

@Composable
fun ProductoCard(
    producto: ProductoDetalle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(6.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(Color(0xFFF3EDF7)),
                contentAlignment = Alignment.Center
            ) {
                val imagenRes = producto.image ?: android.R.drawable.ic_menu_gallery
                Image(
                    painter = painterResource(id = imagenRes),
                    contentDescription = producto.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = producto.name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF212121),
                maxLines = 2,
                minLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))
            val formattedPrice = String.format(Locale.US, "$%,.2f", producto.price)
            Text(
                text = formattedPrice,
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFFE10050),
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE10050)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(38.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Agregar",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}