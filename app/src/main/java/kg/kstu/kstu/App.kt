package kg.kstu.kstu

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        private var instance: App? = null
        lateinit var sheredPrefs: SharedPreferences
        fun getInstance(): App = instance!!
    }
}
