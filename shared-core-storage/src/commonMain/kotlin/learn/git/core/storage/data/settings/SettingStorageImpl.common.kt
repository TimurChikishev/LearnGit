package learn.git.core.storage.data.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

internal class SettingStorageImpl(
    private val datastore: DataStore<Preferences>,
) : SettingsStorage {
    override suspend fun isFirstLaunch(): Boolean {
        return datastore.data
            .map { preferences -> preferences[KEY_IS_FIRST_LAUNCH] ?: true }
            .first()
    }

    override suspend fun setFirstLaunch() {
        datastore.edit { preference ->
            preference[KEY_IS_FIRST_LAUNCH] = true
        }
    }

    companion object {

        private val KEY_IS_FIRST_LAUNCH = booleanPreferencesKey("KEY_IS_FIRST_LAUNCH")
    }
}
