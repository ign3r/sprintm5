package com.example.sprintm5.ui.cart

import CartViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sprintm5.model.Producto
import com.example.sprintm5.ui.home.ProductCard
import com.example.sprintm5.ui.home.ProductCardShopping
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun CartView(cartViewModel: CartViewModel = viewModel()) {
    val carrito = cartViewModel.carrito.collectAsState()
    val totalPrecio = cartViewModel.totalPrecio.collectAsState()
// Formateador para redondear y usar un punto como separador de miles
    val dec = DecimalFormat("#,###")
    dec.decimalFormatSymbols = DecimalFormatSymbols().apply {
        groupingSeparator = '.' // Cambia el separador de miles a un punto
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn (modifier = Modifier.size(600.dp), horizontalAlignment =Alignment.CenterHorizontally ){
            items(carrito.value) { producto ->
                ProductCardShopping(producto, onClick = { cartViewModel.eliminarProducto(producto) })
            }


        }

        // Total y botón "Pagar"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical=5.dp, horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total: $${dec.format(totalPrecio.value)}",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text("Pagar", color = Color.White)
            }
        }


        Button(
            onClick = { cartViewModel.limpiarCarrito() },
            modifier = Modifier.padding(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)

        ) {
            Text("Limpiar carrito",
                color = Color.White
                )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}
