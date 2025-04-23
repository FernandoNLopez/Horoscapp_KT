package com.learning.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.learning.horoscapp.data.providers.HoroscopeProvider
import com.learning.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    //getInfo from domain model
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope


    init {
       _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}