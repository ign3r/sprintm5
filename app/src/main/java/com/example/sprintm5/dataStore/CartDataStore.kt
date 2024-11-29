package com.example.sprintm5.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.sprintm5.model.Producto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//// DataStore instance
//private val Context.dataStore by preferencesDataStore(name = "cart_prefs")
//
//class CartPreferences(private val context: Context) {
//    companion object {
//        private val CART_KEY = stringSetPreferencesKey("cart_items")
//    }
//
//    // Obtener los productos guardados
//    val cartItems: Flow<Set<String>> = context.dataStore.data.map { preferences ->
//        preferences[CART_KEY] ?: emptySet()
//    }
//
//    // Guardar los productos
//    suspend fun saveCartItems(productIds: Set<String>) {
//        context.dataStore.edit { preferences ->
//            preferences[CART_KEY] = productIds
//        }
//    }
//}

//private val Context.dataStore by preferencesDataStore(name = "cart_prefs")
//
//class CartPreferences(private val context: Context) {
//    companion object {
//        private val CART_KEY = stringSetPreferencesKey("cart_items")
//    }
//
//    val cartItems: Flow<Set<String>> = context.dataStore.data.map { preferences ->
//        preferences[CART_KEY] ?: emptySet()
//    }
//
//    suspend fun saveCartItems(productIds: Set<String>) {
//        context.dataStore.edit { preferences ->
//            preferences[CART_KEY] = productIds
//        }
//    }
//}

//class CartPreferences(private val context: Context) {
//    companion object {
//        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("cart_prefs")
//        val CART_KEY = stringPreferencesKey("cart_items")
//    }
//
//    val cartItems: Flow<String> = context.dataStore.data
//        .map { preferences ->
//            preferences[CART_KEY] ?: ""
//        }
//
//    suspend fun saveCartItems(productIds: Set<String>) {
//        context.dataStore.edit { preferences ->
////            preferences[CART_KEY] = productIds
//        }
//    }
//}

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CartPreferences(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("cart_prefs")
        private val CART_KEY = stringPreferencesKey("cart_items")
    }

    val cartItems: Flow<Set<String>> = context.dataStore.data
        .map { preferences ->
            val cartJson = preferences[CART_KEY] ?: "[]"
            try {
                Json.decodeFromString<Set<String>>(cartJson)
            } catch (e: Exception) {
                emptySet() // Retorna un set vacío si ocurre un error de deserialización
            }
        }

    suspend fun saveCartItems(productIds: Set<String>) {
        context.dataStore.edit { preferences ->
            preferences[CART_KEY] = Json.encodeToString(productIds)
        }
    }
}
