package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.sirthomas.clantracker.R
import xyz.sirthomas.clantracker.model.Player

@Composable
fun HomeScreen(
    tag: String,
    clashUiState: ClashUiState,
    updateTag: (String) -> Unit,
    lookupPlayer: () -> Unit,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (clashUiState) {
        is ClashUiState.Start -> StartScreen(tag, updateTag, lookupPlayer, modifier)
        is ClashUiState.Loading -> LoadingScreen(modifier)
        is ClashUiState.Success -> PlayerDisplayScreen(clashUiState.player, modifier)
        is ClashUiState.Error -> ErrorScreen(clashUiState.e, retryAction, modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}

@Composable
fun ErrorScreen(e: Exception, retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.loading_failed))
        Text(e.toString())
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
fun PlayerDisplayScreen(player: Player, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            player.toString(),
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}

@Composable
fun StartScreen(tag: String, setTag: (String) -> Unit, lookupPlayer: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            TextField(value = tag, onValueChange = setTag)
            Button(onClick = lookupPlayer) {
                Text(stringResource(R.string.search))
            }
        }
    }
}