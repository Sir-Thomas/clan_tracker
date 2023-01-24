package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.sirthomas.clantracker.R

@Composable
fun DisplayScreen(
    clashUiState: ClashUiState,
    modifier: Modifier = Modifier
) {
    when (clashUiState) {
        is ClashUiState.Loading -> LoadingScreen(modifier)
        is ClashUiState.ClanUiState -> ClanDisplay(clashUiState.clan, modifier)
        is ClashUiState.PlayerUiState -> PlayerDisplay(clashUiState.player, modifier)
        is ClashUiState.Error -> ErrorScreen(clashUiState.e, modifier)
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
fun ErrorScreen(e: Exception, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.loading_failed))
        Text(e.toString())
    }
}