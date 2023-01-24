package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import xyz.sirthomas.clantracker.R
import xyz.sirthomas.clantracker.model.Clan
import xyz.sirthomas.clantracker.model.Player

@Composable
fun ClanDisplay(clan: Clan, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(clan.badgeUrls.medium)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = clan.name,
                style = MaterialTheme.typography.h1
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = clan.tag,
            style = MaterialTheme.typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        clan.description?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.h2
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        MemberList(clan.memberList)
    }
}

@Composable
fun MemberList(members: List<Player>?) {
    members?.forEach {
        Text(text = it.name)
    }
}