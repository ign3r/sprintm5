package com.example.sprintm5.ui.productdetail

import CartViewModel
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sprintm5.model.Producto

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun ProductDetailView(producto: Producto, cartViewModel: CartViewModel) {
    var selectedSize by remember { mutableStateOf<String?>(null) }
    var selectedColor by remember { mutableStateOf<String?>(null) }
    // Formateador para redondear y usar un punto como separador de miles
    val dec = DecimalFormat("#,###")
    dec.decimalFormatSymbols = DecimalFormatSymbols().apply {
        groupingSeparator = '.' // Cambia el separador de miles a un punto
    }
    Column(modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(producto.imagen),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(producto.nombre, style = MaterialTheme.typography.h4)
        Text(producto.descripcion, color = Color.Gray )
        Text("Precio: $${dec.format(producto.precio)}", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            producto.tallas.forEach { size ->
                Button(
                    onClick = { selectedSize = size },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (selectedSize == size) Color.LightGray else Color.Gray
                    ),
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = size.toString())
                }
            }
        }

        Row {
            producto.colores.forEach { color ->
                Button(
                    onClick = { selectedColor = color },
                    shape= RoundedCornerShape(100),

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = (if (color == "Blanco") Color.White
                        else if (color == "Negro") Color.Black
                        else if(color == "Azul") Color.Blue
                        else if(color == "Rojo") Color.Red
                        else if(color == "Gris") Color.Gray
                        else TODO()) as Color
                    ),
                    border = (if (selectedColor==color) BorderStroke(5.dp, Color.LightGray) else BorderStroke(0.dp, Color.Black)),

                    modifier = Modifier.padding(10.dp)
                        .size(40.dp)



                ) {
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { cartViewModel.agregarProducto(producto) },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("Agregar al carrito",
                color = Color.White)
        }
    }
}


