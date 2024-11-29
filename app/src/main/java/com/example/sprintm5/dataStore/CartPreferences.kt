//package com.example.sprintm5.datastore
//
//import android.content.Context
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.stringSetPreferencesKey
//import androidx.datastore.preferences.preferencesDataStore
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
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
