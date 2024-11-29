package com.example.sprintm5.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sprintm5.model.Producto
import com.example.sprintm5.R

class ProductViewModel : ViewModel() {
    val zapatos = listOf(
        Producto(
            "1",
            "Zapato Oxford Clásico",
            R.drawable.zapato1,
            49990.0,
            "Zapato formal de cuero genuino, ideal para reuniones de negocios o eventos importantes. Cuenta con un diseño elegante y resistente.",
            listOf("40", "41", "42"),
            listOf("Negro", "Rojo", "Blanco", "Azul")
        ),
        Producto(
            "2",
            "Mocasín Casual Comfort",
            R.drawable.zapato2,
            59990.0,
            "Zapato casual de estilo moderno, fabricado en gamuza y diseñado para brindar comodidad durante todo el día.",
            listOf("40", "41", "43"),
            listOf("Negro", "Gris")
        ),
        Producto(
            "3",
            "Zapato Derby Minimalista",
            R.drawable.zapato3,
            29990.0,
            "Un zapato versátil para uso diario, hecho con materiales ligeros y un diseño atemporal.",
            listOf("40", "41", "43"),
            listOf("Negro", "Gris")
        ),
        Producto(
            "4",
            "Botín de Cuero Urbano",
            R.drawable.zapato4,
            69990.0,
            "Botines de cuero premium, perfectos para un look casual y moderno. Incluyen plantilla acolchada para mayor confort.",
            listOf("40", "41", "43"),
            listOf("Negro", "Gris")
        ),
        Producto(
            "5",
            "Zapato Monk Strap Doble",
            R.drawable.zapato5,
            89990.0,
            "Un clásico reinventado con hebillas dobles y detalles en cuero pulido, ideal para quienes buscan elegancia con un toque distintivo.",
            listOf("40", "41", "43"),
            listOf("Negro", "Gris")
        )

    )

    val zapatillas = listOf(
        Producto(
            "6",
            "Zapatilla Running Pro",
            R.drawable.zapatilla1,
            39990.0,
            "Zapatilla deportiva diseñada para corredores. Cuenta con tecnología de amortiguación avanzada y suela antideslizante.",
            listOf("38", "39", "40"),
            listOf("Blanco", "Azul")
        ),
        Producto(
            "7",
            "Zapatilla Urbana Streetwear",
            R.drawable.zapatilla2,
            44990.0,
            "Zapatilla casual con diseño moderno, perfecta para combinar con ropa urbana. Hechas con materiales ligeros y transpirables.",
            listOf("37", "38", "40"),
            listOf("Rojo", "Negro")
        ),
        Producto(
            "8",
            "Zapatilla Trekking Adventure",
            R.drawable.zapatilla3,
            49990.0,
            "Diseñada para aventuras al aire libre, con protección extra en la suela y soporte en el tobillo para terrenos irregulares.",
            listOf("37", "38", "40"),
            listOf("Rojo", "Negro")
        ),
        Producto(
            "9",
            "Zapatilla Premium Sneakers",
            R.drawable.zapatilla4,
            78990.0,
            "Edición limitada de zapatillas con diseño exclusivo. Materiales de alta calidad para un estilo único y sofisticado.",
            listOf("37", "38", "40"),
            listOf("Rojo", "Negro")
        ),
        Producto(
            "10",
            "Zapatilla de Cuero High-End",
            R.drawable.zapatilla5,
            84990.0,
            "Zapatilla premium de cuero natural con acabados detallados. Perfectas para un look casual pero elegante.",
            listOf("37", "38", "40"),
            listOf("Rojo", "Negro")
        )
    )
}


object ProductData {val productosDisponibles = listOf(
    Producto(
        "1",
        "Zapato Oxford Clásico",
        R.drawable.zapato1,
        49990.0,
        "Zapato formal de cuero genuino, ideal para reuniones de negocios o eventos importantes. Cuenta con un diseño elegante y resistente.",
        listOf("40", "41", "42"),
        listOf("Negro", "Rojo", "Blanco", "Azul")
    ),
    Producto(
        "2",
        "Mocasín Casual Comfort",
        R.drawable.zapato2,
        59990.0,
        "Zapato casual de estilo moderno, fabricado en gamuza y diseñado para brindar comodidad durante todo el día.",
        listOf("40", "41", "43"),
        listOf("Negro", "Gris")
    ),
    Producto(
        "3",
        "Zapato Derby Minimalista",
        R.drawable.zapato3,
        29990.0,
        "Un zapato versátil para uso diario, hecho con materiales ligeros y un diseño atemporal.",
        listOf("40", "41", "43"),
        listOf("Negro", "Gris")
    ),
    Producto(
        "4",
        "Botín de Cuero Urbano",
        R.drawable.zapato4,
        69990.0,
        "Botines de cuero premium, perfectos para un look casual y moderno. Incluyen plantilla acolchada para mayor confort.",
        listOf("40", "41", "43"),
        listOf("Negro", "Gris")
    ),
    Producto(
        "5",
        "Zapato Monk Strap Doble",
        R.drawable.zapato5,
        89990.0,
        "Un clásico reinventado con hebillas dobles y detalles en cuero pulido, ideal para quienes buscan elegancia con un toque distintivo.",
        listOf("40", "41", "43"),
        listOf("Negro", "Gris")
    ),
    Producto(
        "6",
        "Zapatilla Running Pro",
        R.drawable.zapatilla1,
        39990.0,
        "Zapatilla deportiva diseñada para corredores. Cuenta con tecnología de amortiguación avanzada y suela antideslizante.",
        listOf("38", "39", "40"),
        listOf("Blanco", "Azul")
    ),
    Producto(
        "7",
        "Zapatilla Urbana Streetwear",
        R.drawable.zapatilla2,
        44990.0,
        "Zapatilla casual con diseño moderno, perfecta para combinar con ropa urbana. Hechas con materiales ligeros y transpirables.",
        listOf("37", "38", "40"),
        listOf("Rojo", "Negro")
    ),
    Producto(
        "8",
        "Zapatilla Trekking Adventure",
        R.drawable.zapatilla3,
        49990.0,
        "Diseñada para aventuras al aire libre, con protección extra en la suela y soporte en el tobillo para terrenos irregulares.",
        listOf("37", "38", "40"),
        listOf("Rojo", "Negro")
    ),
    Producto(
        "9",
        "Zapatilla Premium Sneakers",
        R.drawable.zapatilla4,
        78990.0,
        "Edición limitada de zapatillas con diseño exclusivo. Materiales de alta calidad para un estilo único y sofisticado.",
        listOf("37", "38", "40"),
        listOf("Rojo", "Negro")
    ),
    Producto(
        "10",
        "Zapatilla de Cuero High-End",
        R.drawable.zapatilla5,
        84990.0,
        "Zapatilla premium de cuero natural con acabados detallados. Perfectas para un look casual pero elegante.",
        listOf("37", "38", "40"),
        listOf("Rojo", "Negro")
    )
)
}
