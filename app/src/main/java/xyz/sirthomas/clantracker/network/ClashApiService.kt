package xyz.sirthomas.clantracker.network

import retrofit2.http.GET
import xyz.sirthomas.clantracker.model.Player

interface ClashApiService {
        @GET("players/9YY0GC2")
        suspend fun getPlayer(tag: String): Player
}