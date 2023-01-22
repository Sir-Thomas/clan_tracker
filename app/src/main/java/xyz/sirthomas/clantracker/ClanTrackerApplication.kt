package xyz.sirthomas.clantracker

import android.app.Application
import xyz.sirthomas.clantracker.data.AppContainer
import xyz.sirthomas.clantracker.data.DefaultAppContainer

class ClanTrackerApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}