package com.learning.horoscapp.domain

import com.learning.horoscapp.data.network.response.PredictionResponse


interface Repository {
    suspend fun getPrediction(sign:String) : PredictionResponse?
}