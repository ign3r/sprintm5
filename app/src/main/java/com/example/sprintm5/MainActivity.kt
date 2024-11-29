package com.example.sprintm5

import CartViewModel
import CartViewModelFactory
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.sprintm5.components.BottomNavigationBar
import com.example.sprintm5.model.Producto
import com.example.sprintm5.navigation.NavGraph
import com.example.sprintm5.ui.theme.SprintM5Theme
import com.example.sprintm5.viewmodel.ProductData
import com.example.sprintm5.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprintM5Theme {

                val productViewModel: ProductViewModel = viewModel()
                val cartViewModel: CartViewModel by viewModels {
                    CartViewModelFactory(this, ProductData.productosDisponibles)
                }

                // Controlador de navegación
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) {
                    // Llamamos al NavGraph donde se gestionará la navegación entre las pantallas
                    NavGraph(navController, productViewModel, cartViewModel)
                }
            }
        }
    }
}

