package com.example.xcompanyassignment.di

import android.util.Log
import com.example.xcompanyassignment.data.remote.RepositoriesApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {

    private const val baseUrl = "https://api.github.com/"
    private val DEFAULT_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(30)

    @Provides
    @Singleton
    fun provideRetrofitApi(retrofit: Retrofit): RepositoriesApi =
        retrofit.create(RepositoriesApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofitBuilder(httpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
            .setLenient().create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideHttpManager(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIMEOUT_MS, TimeUnit.MILLISECONDS)
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor {
            it.chunked(2048).forEach { logMessage ->
                Log.d("Okhttp", logMessage)
            }
        }
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}