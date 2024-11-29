package com.example.sprintm5.model

data class Producto(
    val id: String,
    val nombre: String,
    val imagen: Int, // Ej. R.drawable.nombre_imagen
    val precio: Double,
    val descripcion: String,
    val tallas: List<String>,
    val colores: List<String>
)
