package xyz.sirthomas.clantracker.ui.screens

import androidx.annotation.StringRes
import xyz.sirthomas.clantracker.R

enum class ClanTrackerScreen(@StringRes val title: Int) {
    Search(title = R.string.app_name),
    Player(title = R.string.player),
    Clan(title = R.string.clan)
}

