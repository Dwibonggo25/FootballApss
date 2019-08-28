package com.example.simplelogin.di.module

import android.app.Application
import com.example.simplelogin.BASE_URL
import com.example.simplelogin.DEFAULT_CONNECT_TIMEOUT
import com.example.simplelogin.DEFAULT_READ_TIMEOUT
import com.example.simplelogin.DEFAULT_WRITE_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideHttpCache(application : Application) : Cache {
        val cacheSize : Long = 10 * 10 * 1024
        return Cache(application.cacheDir , cacheSize)
    }

    @Provides
    @Singleton
    fun getRequestHeader(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder().build()
            chain.proceed(request)
        }
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInterface(baseUrl: String, okHttpClient: OkHttpClient  ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}