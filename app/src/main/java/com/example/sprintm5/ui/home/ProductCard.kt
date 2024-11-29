package com.example.sprintm5.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sprintm5.model.Producto
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun ProductCard(producto: Producto, onClick: () -> Unit) {
    // Formateador para redondear y usar un punto como separador de miles
    val dec = DecimalFormat("#,###")
    dec.decimalFormatSymbols = DecimalFormatSymbols().apply {
        groupingSeparator = '.' // Cambia el separador de miles a un punto
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(300.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(producto.imagen),
                contentDescription = null,
                modifier = Modifier.size(180.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = "$${dec.format(producto.precio)}", // Formatea el precio con separador de miles
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

