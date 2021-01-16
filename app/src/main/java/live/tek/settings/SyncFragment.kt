package live.tek.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import live.tek.settings.storage.SettingDataStore

@Suppress("unused")
class SyncFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.sync_preferences, rootKey)

        val preferenceManager = preferenceManager
        val dataStore = SettingDataStore(requireContext())
        preferenceManager.preferenceDataStore = dataStore

        val sync= findPreference<SwitchPreferenceCompat>("sync")
        sync?.isChecked= dataStore.getBoolean("sync",false)

        val attachment = findPreference<SwitchPreferenceCompat>("attachment")
        attachment?.isChecked=dataStore.getBoolean("attachment",false)
    }
}