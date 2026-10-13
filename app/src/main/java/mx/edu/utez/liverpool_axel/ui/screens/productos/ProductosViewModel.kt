package mx.edu.utez.liverpool_axel.ui.screens.productos

import androidx.lifecycle.ViewModel
import mx.edu.utez.liverpool_axel.R
import mx.edu.utez.liverpool_axel.model.Comentario
import mx.edu.utez.liverpool_axel.model.ProductoDetalle

class ProductosViewModel : ViewModel() {

    val productos = listOf(
        ProductoDetalle(
            brand = "Sony",
            name = "Camara de video digital",
            price = 2500.0,
            rating = 4.8f,
            reviewCount = 128,
            isFreeShipping = true,
            isFavorite = true,
            description = "Una buena camara para hacer videos, blogs o guardar momentos especiales",
            image = R.drawable.cam,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "Buena camara", calificacion = 5f),
                Comentario(usuario = "Irving", texto = "Llegó en perfectas condiciones.", calificacion = 4.8f),
                Comentario(usuario = "Cristian", texto = "No encendio cuando llego", calificacion = 1f),
                Comentario(usuario = "Luis", texto = "Tuve problemas para entender como usarla, pero la recomiendo", calificacion = 3.5f)

            )
        ),
        ProductoDetalle(
            brand = "Sony",
            name = "PSP edición final fantasy",
            price = 999999.0,
            rating = 4.5f,
            reviewCount = 85,
            isFreeShipping = false,
            isFavorite = false,
            description = "Edicion especial de increible consola portatil",
            image = R.drawable.psp,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "Se me perdieron las tapas", calificacion = 3f),
                Comentario(usuario = "Irving", texto = "Llegó en perfectas condiciones.", calificacion = 5f),
                Comentario(usuario = "Cristian", texto = "La voy a chipear", calificacion = 5f),
                Comentario(usuario = "Luis", texto = "Bueno el Kirby y el laberinto de los espejos", calificacion = 5f)

            )
        ),
        ProductoDetalle(
            brand = "Microsoft",
            name = "Guitar hero guitarra",
            price = 750.0,
            rating = 4.7f,
            reviewCount = 320,
            isFreeShipping = false,
            isFavorite = false,
            description = "Guitarra para jugar al guitar hero en consola xbox",
            image = R.drawable.guitar,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "No funcionan los botones", calificacion = 2f),
                Comentario(usuario = "Irving", texto = "Me pase un buen rato.", calificacion = 5f),
                Comentario(usuario = "Cristian", texto = "Se trabo en dragonforce", calificacion =3f),
                Comentario(usuario = "Luis", texto = "Me gusto el diseño", calificacion = 4f)
            )
        ),
        ProductoDetalle(
            brand = "Covenant",
            name = "Espada de energia",
            price = 5000.0,
            rating = 4.9f,
            reviewCount = 56,
            isFreeShipping = false,
            isFavorite = true,
            description = "Muy buena para cortar mantequilla",
            image = R.drawable.sable,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "Buena para las tortas", calificacion = 5f),
                Comentario(usuario = "Irving", texto = "Llegó en perfectas condiciones.", calificacion = 5f),
                Comentario(usuario = "Cristian", texto = "Se le acabo la energia", calificacion = 1f),
                Comentario(usuario = "Luis", texto = "Atravesó la pared", calificacion = 4f)

            )
        ),
        ProductoDetalle(
            brand = "Sony pictures",
            name = "Breaking bad blue ray",
            price = 800.0,
            rating = 4.8f,
            reviewCount = 210,
            isFreeShipping = false,
            isFavorite = false,
            description = "Serie buenisima, vela si no la haz visto",
            image = R.drawable.breakingbad,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "Increible", calificacion = 5f),
                Comentario(usuario = "Irving", texto = "Discos rayados", calificacion = 0f),
                Comentario(usuario = "Cristian", texto = "La escena de skyler y todd malisima", calificacion = 3f),
                Comentario(usuario = "Luis", texto = "Buena serie", calificacion = 4.5f)

            )
        ),
        ProductoDetalle(
            brand = "From Software",
            name = "Dark souls disco para xbox 360",
            price = 600.0,
            rating = 4.6f,
            reviewCount = 145,
            isFreeShipping = true,
            isFavorite = false,
            description = "Juego epico, cuidado con Artorias",
            image = R.drawable.darksouls,
            reviews = listOf(
                Comentario(usuario = "Axel", texto = "El mejor juego que he jugado hasta ahora", calificacion = 5f),
                Comentario(usuario = "Irving", texto = "Muy dificil", calificacion = 2.5f),
                Comentario(usuario = "Cristian", texto = "No puedo matar a Queelag", calificacion = 3.5f),
                Comentario(usuario = "Luis", texto = "Gwyndolin", calificacion = 5f)

            )
        )
    )

    var productoSeleccionado: ProductoDetalle = productos[0]
}