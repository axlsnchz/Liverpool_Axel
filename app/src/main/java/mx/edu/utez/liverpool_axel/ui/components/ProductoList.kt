package mx.edu.utez.liverpool_axel.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.edu.utez.liverpool_axel.model.ProductoDetalle

@Composable
fun ProductoList(
    productosAgrupados: List<List<ProductoDetalle>>,
    onProductoSelected: (ProductoDetalle) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(productosAgrupados) { fila ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProductoCard(
                    producto = fila[0],
                    onClick = { onProductoSelected(fila[0]) },
                    modifier = Modifier.weight(1f)
                )

                if (fila.size > 1) {
                    ProductoCard(
                        producto = fila[1],
                        onClick = { onProductoSelected(fila[1]) },
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))

                }
            }
        }
    }
}