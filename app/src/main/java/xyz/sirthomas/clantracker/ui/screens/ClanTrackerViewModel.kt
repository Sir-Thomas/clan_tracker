package xyz.sirthomas.clantracker.ui.screens

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
import xyz.sirthomas.clantracker.model.Player
import java.io.IOException

sealed interface ClashUiState {
    object Start : ClashUiState
    data class Success(val player: Player) : ClashUiState
    data class Error(val e: Exception) : ClashUiState
    object Loading : ClashUiState
}

class ClanTrackerViewModel(private val clashData: ClashData) : ViewModel() {
    var clashUiState: ClashUiState by mutableStateOf(ClashUiState.Start)
        private set

    var tag: String by mutableStateOf("")
        private set

    fun updateTag(t: String) {
        tag = t
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun getPlayerInfo() {
        viewModelScope.launch {
            clashUiState = ClashUiState.Loading
            clashUiState = try {
                ClashUiState.Success(clashData.getPlayerData(tag.trim('#')))
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