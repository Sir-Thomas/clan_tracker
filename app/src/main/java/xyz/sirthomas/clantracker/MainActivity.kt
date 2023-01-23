package xyz.sirthomas.clantracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.sirthomas.clantracker.ui.ClanTrackerApp
import xyz.sirthomas.clantracker.ui.theme.ClanTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClanTrackerTheme {
                ClanTrackerApp()
            }
        }
    }
}