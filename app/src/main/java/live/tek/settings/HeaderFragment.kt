package live.tek.settings

import android.os.Bundle
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class HeaderFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.header_preferences, rootKey)
        findPreference<Preference>("messages_header")?.setOnPreferenceClickListener {
            Log.e("ItemClicked",it.key)
            requireParentFragment().childFragmentManager.beginTransaction()
                .replace(R.id.inner_container, MessagesFragment(),"Message").addToBackStack(null).commit()
            true
        }
        findPreference<Preference>("sync_header")?.setOnPreferenceClickListener {
                requireParentFragment().childFragmentManager.beginTransaction()
                    .replace(R.id.inner_container, SyncFragment(),"Sync").addToBackStack(null).commit()
            true
        }

    }
}