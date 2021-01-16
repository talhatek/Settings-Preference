package live.tek.settings

import android.os.Bundle
import android.util.Log
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import live.tek.settings.storage.SettingDataStore

class MessagesFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.messages_preferences, rootKey)
        val preferenceManager = preferenceManager
        val dataStore = SettingDataStore(requireContext())
        preferenceManager.preferenceDataStore = dataStore

        val signature = findPreference<EditTextPreference>("signature")
        signature?.text = dataStore.getString("signature", null)


        val reply = findPreference<ListPreference>("reply")
        reply?.value=dataStore.getString("reply", null)

    }
}