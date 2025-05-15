package com.learning.horoscapp.data.network

import com.learning.horoscapp.BuildConfig.BASE_URL
import com.learning.horoscapp.data.core.interceptors.AuthInterceptor
import com.learning.horoscapp.data.repository.RepositoryImplementation
import com.learning.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeAPIService(retrofit: Retrofit): HoroscopeAPIService {
        return retrofit.create(HoroscopeAPIService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeAPIService) : Repository {
        return RepositoryImplementation(apiService)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }
}