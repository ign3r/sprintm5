package com.example.sprintm5.navigation

import CartViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sprintm5.ui.cart.CartView
import com.example.sprintm5.ui.home.ProductListView
import com.example.sprintm5.ui.productdetail.ProductDetailView
import com.example.sprintm5.ui.profile.ProfileView
import com.example.sprintm5.viewmodel.ProductViewModel

@Composable
fun NavGraph(navController: NavHostController,
             productViewModel: ProductViewModel,
             cartViewModel: CartViewModel
) {
    NavHost(navController = navController, startDestination = "productList") {
        composable("productList") {
            ProductListView(productViewModel) { producto ->
                navController.navigate("productDetail/${producto.nombre}")
            }
        }
        composable("productDetail/{productName}") { backStackEntry ->
            val productName = backStackEntry.arguments?.getString("productName")
            val producto = productViewModel.zapatos.plus(productViewModel.zapatillas).find { it.nombre == productName }
            producto?.let { ProductDetailView(it, cartViewModel) }
        }
        composable("cart") {
            CartView(cartViewModel)
        }
        composable("profile") {
            ProfileView()
        }

    }
}


