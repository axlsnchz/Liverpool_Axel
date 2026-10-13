package mx.edu.utez.liverpool_axel.model
import java.util.UUID

data class Comentario(
    val id: String = UUID.randomUUID().toString(),
    val usuario: String,
    val texto: String,
    val calificacion: Float
)

