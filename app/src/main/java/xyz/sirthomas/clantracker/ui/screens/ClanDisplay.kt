package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import xyz.sirthomas.clantracker.model.Clan
import xyz.sirthomas.clantracker.model.Player
import xyz.sirthomas.clantracker.util.ShowIcon
import xyz.sirthomas.clantracker.util.getTownhallImage

@Composable
fun ClanDisplay(clan: Clan, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        NameTagDisplay(clan = clan)
        Spacer(modifier = Modifier.height(8.dp))
        MemberList(clan.memberList)
    }
}

@Composable
fun NameTagDisplay(clan: Clan) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShowIcon(clan.badgeUrls.medium)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = clan.name,
            style = MaterialTheme.typography.h1
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = clan.tag,
        style = MaterialTheme.typography.h3
    )
    Spacer(modifier = Modifier.height(8.dp))
    clan.description?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun TownhallSpread(memberList: List<Player>) {
    val groupedByTownHallLevel = memberList.groupBy { member -> member.townHallLevel }
    Row {
        groupedByTownHallLevel.forEach { (lvl, players) ->
            Column {
                Image(
                    painter = painterResource(getTownhallImage(lvl)),
                    contentDescription = "Town Hall $lvl",
                    modifier = Modifier.size(50.dp)
                )
                Text(text = "${players.size}")
            }
        }
    }
}

@Composable
fun MemberList(members: List<Player>?) {
    members?.forEach {
        Row {
            ShowIcon(url = it.league?.iconUrls?.small)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = it.name,
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = it.role!!)
        }
    }
}