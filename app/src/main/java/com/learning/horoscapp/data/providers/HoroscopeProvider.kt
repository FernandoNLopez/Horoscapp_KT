package com.learning.horoscapp.data.providers

import com.learning.horoscapp.domain.model.HoroscopeInfo
import com.learning.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject


class HoroscopeProvider @Inject constructor(){
    fun getHoroscopes():List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
           Pisces
        )
    }
}