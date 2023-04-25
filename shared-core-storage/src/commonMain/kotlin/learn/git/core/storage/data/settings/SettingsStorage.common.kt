package learn.git.core.storage.data.settings

interface SettingsStorage {

    suspend fun isFirstLaunch(): Boolean

    suspend fun setFirstLaunch()
}
