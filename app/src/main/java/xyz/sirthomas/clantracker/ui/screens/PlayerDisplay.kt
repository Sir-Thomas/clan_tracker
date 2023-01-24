package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import xyz.sirthomas.clantracker.model.Player

@Composable
fun PlayerDisplay(
    player: Player,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(player.name)
        Text(player.tag)
    }
}