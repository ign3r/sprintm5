package com.example.sprintm5.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var route: String) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "productList")
    object Cart : BottomNavItem("Carrito", Icons.Default.ShoppingCart, "cart")
    object Profile : BottomNavItem("Perfil", Icons.Default.Person, "profile")
}

