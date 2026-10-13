package mx.edu.utez.liverpool_axel.ui.screens.detalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_axel.ui.components.ComentarioList
import mx.edu.utez.liverpool_axel.ui.components.ProductoRatingBar
import mx.edu.utez.liverpool_axel.ui.screens.productos.ProductosViewModel
import java.util.Locale

@Composable
fun DetallesScreen(
    viewModel: ProductosViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val producto = viewModel.productoSeleccionado
    var esFavorito by remember { mutableStateOf(producto.isFavorite) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Regresar",
                tint = Color(0xFF212121),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onNavigateBack() }
            )

            Row {

                Icon(
                    imageVector = if (esFavorito) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = if (esFavorito) Color(0xFFE10050) else Color(0xFF212121),
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { esFavorito = !esFavorito }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
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
                            .padding(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = producto.brand.uppercase(),
                    color = Color(0xFFE10050),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = producto.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF212121),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                ProductoRatingBar(
                    comentarios = producto.reviews,
                    defaultRating = producto.rating,
                    reviewCount = producto.reviewCount
                )

                Spacer(modifier = Modifier.height(12.dp))

                val formattedPrice = String.format(Locale.US, "$%,.2f", producto.price)
                Text(
                    text = formattedPrice,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF212121),
                    fontWeight = FontWeight.Bold
                )

                if (producto.isFreeShipping) {
                    Surface(
                        color = Color(0xFFE8F5E9),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalShipping,
                                contentDescription = "Envío gratis",
                                tint = Color(0xFF2E7D32),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Envío gratis",
                                color = Color(0xFF2E7D32),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Descripción",
                    color = Color(0xFF212121),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = producto.description,
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ComentarioList(comentarios = producto.reviews)
                Spacer(modifier = Modifier.height(28.dp))
            }

            item {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE10050)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Agregar a mi bolsa",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}