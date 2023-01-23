package xyz.sirthomas.clantracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.sirthomas.clantracker.R
import xyz.sirthomas.clantracker.ui.screens.ClanTrackerViewModel
import xyz.sirthomas.clantracker.ui.screens.HomeScreen

@Composable
fun ClanTrackerApp(modifier: Modifier = Modifier) {
    Scaffold(
    modifier = modifier.fillMaxSize(),
    topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val clanTrackerViewModel: ClanTrackerViewModel =
                viewModel(factory = ClanTrackerViewModel.Factory)
            HomeScreen(
                tag = clanTrackerViewModel.tag,
                clashUiState = clanTrackerViewModel.clashUiState,
                updateTag = { clanTrackerViewModel.updateTag(it) },
                lookupPlayer = { clanTrackerViewModel.getPlayerInfo() },
                backAction = { clanTrackerViewModel.restart() }
            )
        }
    }
}