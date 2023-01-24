package xyz.sirthomas.clantracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import xyz.sirthomas.clantracker.R
import xyz.sirthomas.clantracker.ui.screens.*

@Composable
fun ClanTrackerAppBar(
    currentScreen: ClanTrackerScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun ClanTrackerApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ClanTrackerScreen.valueOf(
        backStackEntry?.destination?.route ?: ClanTrackerScreen.Search.name
    )
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ClanTrackerAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val clanTrackerViewModel: ClanTrackerViewModel =
            viewModel(factory = ClanTrackerViewModel.Factory)

        NavHost(
            navController = navController,
            startDestination = ClanTrackerScreen.Search.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = ClanTrackerScreen.Search.name) {
                SearchScreen(
                    tag = clanTrackerViewModel.tag,
                    updateTag = { clanTrackerViewModel.updateTag(it) },
                    searchType = clanTrackerViewModel.searchType,
                    updateSearchType = { clanTrackerViewModel.updateSearchType(it) },
                    search = {
                        clanTrackerViewModel.search()
                        when (clanTrackerViewModel.searchType) {
                            SearchType.Clan -> navController.navigate(ClanTrackerScreen.Clan.name)
                            SearchType.Player -> navController.navigate(ClanTrackerScreen.Player.name)
                        }
                    },
                )
            }
            composable(route = ClanTrackerScreen.Clan.name) {
                DisplayScreen(clashUiState = clanTrackerViewModel.clashUiState)
            }
            composable(route = ClanTrackerScreen.Player.name) {
                DisplayScreen(clashUiState = clanTrackerViewModel.clashUiState)
            }
        }
    }
}