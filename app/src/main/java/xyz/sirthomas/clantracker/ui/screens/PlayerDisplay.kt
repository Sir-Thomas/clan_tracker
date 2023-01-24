package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import xyz.sirthomas.clantracker.model.Player
import xyz.sirthomas.clantracker.util.ShowIcon
import xyz.sirthomas.clantracker.util.getTownhallImage

@Composable
fun PlayerDisplay(
    player: Player,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.height(100.dp)
        ) {
            Image(
                painter = painterResource(getTownhallImage(player.townHallLevel, player.townHallWeaponLevel)),
                contentDescription = "Town Hall ${player.townHallLevel}",
                modifier = Modifier.size(100.dp)
            )
            Spacer(Modifier.width(4.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = player.name,
                    style = MaterialTheme.typography.h1
                )
                Text(text = player.tag)
                Row {
                    ShowIcon(player.league?.iconUrls?.small)
                    Text("${player.trophies}")
                }
            }
        }

    }
}