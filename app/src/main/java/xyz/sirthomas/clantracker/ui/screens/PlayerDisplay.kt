package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import xyz.sirthomas.clantracker.model.Player
import xyz.sirthomas.clantracker.util.getTownhallImage

@Composable
fun PlayerDisplay(
    player: Player,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = player.name,
            style = MaterialTheme.typography.h1
        )
        Text(text = player.tag)
        Image(
            painter = painterResource(getTownhallImage(player.townHallLevel, player.townHallWeaponLevel)),
            contentDescription = "Town Hall ${player.townHallLevel}"
        )
        Text("\uD83C\uDFC6 ${player.trophies}")
    }
}