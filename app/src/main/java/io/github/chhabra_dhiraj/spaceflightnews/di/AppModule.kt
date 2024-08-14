package io.github.chhabra_dhiraj.spaceflightnews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val PREFIX_BASE_URL = "v4"
private const val BASE_URL = "https://api.spaceflightnewsapi.net/$PREFIX_BASE_URL/"
private const val DEFAULT_MEDIA_TYPE = "application/json; charset=UTF8"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideArticleApi(): ArticleApi {
        val networkJson = Json {
            ignoreUnknownKeys = true
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                networkJson.asConverterFactory(DEFAULT_MEDIA_TYPE.toMediaType())
            )
            .build()
            .create()
    }
}