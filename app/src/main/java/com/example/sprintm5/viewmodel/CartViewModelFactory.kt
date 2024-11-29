import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sprintm5.model.Producto

class CartViewModelFactory(
    private val context: Context,
    private val productosDisponibles: List<Producto>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(context, productosDisponibles) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
