package com.learning.horoscapp.domain

import com.learning.horoscapp.domain.model.PredictionModel


interface Repository {
    suspend fun getPrediction(sign:String) : PredictionModel?
}