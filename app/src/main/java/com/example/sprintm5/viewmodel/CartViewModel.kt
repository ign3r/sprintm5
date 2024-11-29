import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprintm5.datastore.CartPreferences
import com.example.sprintm5.model.Producto
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CartViewModel(context: Context, productosDisponibles: List<Producto>) : ViewModel() {

    private val cartPreferences = CartPreferences(context)
    private val _carrito = MutableStateFlow<List<Producto>>(emptyList())
    val carrito: StateFlow<List<Producto>> = _carrito

    val totalPrecio: StateFlow<Double> = carrito
        .map { lista -> lista.sumOf { it.precio } }
        .stateIn(viewModelScope, SharingStarted.Lazily, 0.0)

    init {
        cargarCarrito(productosDisponibles)
    }

    fun agregarProducto(producto: Producto) {
        viewModelScope.launch {
            if (_carrito.value.none { it.id == producto.id }) {
                _carrito.value = _carrito.value + producto
                guardarCarrito()
            }
        }
    }

    fun eliminarProducto(producto: Producto) {
        viewModelScope.launch {
            _carrito.value = _carrito.value.filter { it.id != producto.id }
            guardarCarrito()
        }
    }

    fun limpiarCarrito() {
        viewModelScope.launch {
            _carrito.value = emptyList()
            guardarCarrito()
        }
    }

    private fun guardarCarrito() {
        viewModelScope.launch {
            val ids = _carrito.value.map { it.id.toString() }.toSet()
            cartPreferences.saveCartItems(ids)
        }
    }

    private fun cargarCarrito(productosDisponibles: List<Producto>) {
        viewModelScope.launch {
            cartPreferences.cartItems.collect { ids ->
                val productosCarrito = productosDisponibles.filter { it.id.toString() in ids }
                _carrito.value = productosCarrito
            }
        }
    }
}





