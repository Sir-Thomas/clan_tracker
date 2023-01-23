package xyz.sirthomas.clantracker.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import xyz.sirthomas.clantracker.BuildConfig
import xyz.sirthomas.clantracker.network.ClashApiService
import java.io.IOException


interface AppContainer {
    val clashData: ClashData
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://cocproxy.royaleapi.dev/"
    private val apiKey = BuildConfig.APIKEY
    
    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            return chain.proceed(newRequest)
        }
    }).build()

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: ClashApiService by lazy {
        retrofit.create(ClashApiService::class.java)
    }

    override val clashData: ClashData by lazy {
        NetworkClashData(retrofitService)
    }
}