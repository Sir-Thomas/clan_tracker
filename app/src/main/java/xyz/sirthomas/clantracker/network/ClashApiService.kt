package xyz.sirthomas.clantracker.network

import retrofit2.http.GET
import retrofit2.http.Path
import xyz.sirthomas.clantracker.model.Clan
import xyz.sirthomas.clantracker.model.Player

interface ClashApiService {
        @GET("v1/players/%23{tag}")
        suspend fun getPlayer(@Path("tag") tag: String): Player

        @GET("v1/clans/%23{tag}")
        suspend fun getClan(@Path("tag") tag: String): Clan
}