package xyz.sirthomas.clantracker.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import xyz.sirthomas.clantracker.network.ClashApiService

interface AppContainer {
    val clashData: ClashData
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://cocproxy.royaleapi.dev/v1"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ClashApiService by lazy {
        retrofit.create(ClashApiService::class.java)
    }

    override val clashData: ClashData by lazy {
        NetworkClashData(retrofitService)
    }
}