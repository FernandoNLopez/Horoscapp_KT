package com.learning.horoscapp.data.repository

import android.util.Log
import com.learning.horoscapp.data.network.HoroscopeAPIService
import com.learning.horoscapp.data.network.response.PredictionResponse
import com.learning.horoscapp.domain.Repository
import retrofit2.Retrofit
import javax.inject.Inject


class RepositoryImplementation @Inject constructor(private val APIService : HoroscopeAPIService) : Repository {

    override suspend fun getPrediction(sign: String) : PredictionResponse? {
        //Petición Retrofit
        kotlin.runCatching { APIService.getHoroscope(sign) }
            .onSuccess { return it }
            .onFailure { Log.i("Fer", "Ha ocurrido un error ${it.message}") }

        return null
    }
}