package xyz.sirthomas.clantracker.data

import xyz.sirthomas.clantracker.model.Player
import xyz.sirthomas.clantracker.network.ClashApiService

interface ClashData {
    suspend fun getPlayerData(): Player
}

class NetworkClashData(
    private val clashApiService: ClashApiService
) : ClashData {
    override suspend fun getPlayerData(): Player = clashApiService.getPlayer("9YY0GC2")
}