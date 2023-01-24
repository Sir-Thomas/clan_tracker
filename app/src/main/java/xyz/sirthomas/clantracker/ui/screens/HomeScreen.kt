package xyz.sirthomas.clantracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.sirthomas.clantracker.R

@Composable
fun SearchScreen(
    tag: String,
    updateTag: (String) -> Unit,
    searchType: SearchType,
    updateSearchType: (SearchType) -> Unit,
    search: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            TextField(value = tag, onValueChange = updateTag)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = searchType == SearchType.Clan,
                    onClick = { updateSearchType(SearchType.Clan) }
                )
                Text(stringResource(R.string.clan))
                RadioButton(
                    selected = searchType == SearchType.Player,
                    onClick = { updateSearchType(SearchType.Player) }
                )
                Text(stringResource(R.string.player))
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = search) {
                    Text(stringResource(R.string.search))
                }
            }
        }
    }
}