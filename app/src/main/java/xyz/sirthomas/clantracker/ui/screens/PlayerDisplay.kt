package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import xyz.sirthomas.clantracker.R
import xyz.sirthomas.clantracker.model.Player
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
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(player.league?.iconUrls?.small)
                            .crossfade(true)
                            .build(),
                        error = painterResource(R.drawable.ic_broken_image),
                        placeholder = painterResource(R.drawable.loading_img),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                    Text("${player.trophies}")
                }
            }
        }

    }
}