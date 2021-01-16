package live.tek.settings.storage

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.preference.PreferenceDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SettingDataStore(context: Context) : PreferenceDataStore() {
    private val userPreferences = UserPreferences(context)

    override fun putString(key: String?, value: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            userPreferences.dataStore.edit { it[stringPreferencesKey(key!!)] = value!! }
        }
    }

    override fun putBoolean(key: String?, value: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            userPreferences.dataStore.edit { it[booleanPreferencesKey(key!!)] = value }
        }
    }

    override fun getString(key: String?, defValue: String?): String? {

        val tmp = runBlocking {
            userPreferences.dataStore.data.map { it[stringPreferencesKey(key!!)] }.firstOrNull()
        }

        return tmp ?: defValue
    }


    override fun getBoolean(key: String?, defValue: Boolean): Boolean {
        val tmp = runBlocking {
            userPreferences.dataStore.data.map { it[booleanPreferencesKey(key!!)] }.firstOrNull()
        }

        return  tmp ?: defValue
    }
}