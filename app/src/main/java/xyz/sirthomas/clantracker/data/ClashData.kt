package xyz.sirthomas.clantracker.data

import xyz.sirthomas.clantracker.model.Player
import xyz.sirthomas.clantracker.network.ClashApiService

interface ClashData {
    suspend fun getPlayerData(tag: String): Player
}

class NetworkClashData(
    private val clashApiService: ClashApiService
) : ClashData {
    override suspend fun getPlayerData(tag: String): Player = clashApiService.getPlayer(tag)
}