package live.tek.settings.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore

class UserPreferences(context: Context) {
    private val applicationContext = context.applicationContext
     val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "user_pref"
        )
    }




}