package xyz.sirthomas.clantracker.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import retrofit2.HttpException
import xyz.sirthomas.clantracker.ClanTrackerApplication
import xyz.sirthomas.clantracker.data.ClashData
import xyz.sirthomas.clantracker.model.Clan
import xyz.sirthomas.clantracker.model.Player
import java.io.IOException

//DEBUG
private const val TAG = "ViewModel"

enum class SearchType {
    Clan,
    Player
}

sealed interface ClashUiState {
    data class ClanUiState(val clan: Clan) : ClashUiState
    data class PlayerUiState(val player: Player) : ClashUiState
    data class Error(val e: Exception) : ClashUiState
    object Loading : ClashUiState
}

class ClanTrackerViewModel(private val clashData: ClashData) : ViewModel() {
    var clashUiState: ClashUiState by mutableStateOf(ClashUiState.Loading)
        private set

    var tag: String by mutableStateOf("")
        private set

    fun updateTag(t: String) {
        tag = t
    }

    var searchType: SearchType by mutableStateOf(SearchType.Clan)
        private set

    fun updateSearchType(s: SearchType) {
        searchType = s
        Log.d(TAG, "Search Type: $searchType")
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun search() {
        viewModelScope.launch {
            clashUiState = ClashUiState.Loading
            clashUiState = try {
                when (searchType) {
                    SearchType.Clan ->
                        ClashUiState.ClanUiState(clashData.getClanData(tag))
                    SearchType.Player ->
                        ClashUiState.PlayerUiState(clashData.getPlayerData(tag))
                }
            } catch (e: IOException) {
                ClashUiState.Error(e)
            } catch (e: HttpException) {
                ClashUiState.Error(e)
            } catch (e: MissingFieldException) {
                ClashUiState.Error(e)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ClanTrackerApplication)
                val clashData = application.container.clashData
                ClanTrackerViewModel(clashData = clashData)
            }
        }
    }
}