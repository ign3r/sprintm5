package com.example.sprintm5.ui.home

import androidx.compose.foundation.lazy.items


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sprintm5.model.Producto
import com.example.sprintm5.viewmodel.ProductViewModel

@Composable
fun ProductListView(productViewModel: ProductViewModel, onProductClick: (Producto) -> Unit) {
    Column {
        Spacer(modifier =Modifier.height(10.dp))
        Text("Zapatos",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 10.dp))
        LazyRow {
            items(productViewModel.zapatos) { producto ->
                ProductCard(producto, onClick = { onProductClick(producto) })
            }
        }

        Text("Zapatillas",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 10.dp))
        LazyRow {
            items(productViewModel.zapatillas) { producto ->
                ProductCard(producto, onClick = { onProductClick(producto) })
            }
        }
    }
}


