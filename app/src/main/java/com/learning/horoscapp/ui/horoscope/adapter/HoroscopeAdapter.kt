package com.learning.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.horoscapp.R
import com.learning.horoscapp.domain.model.HoroscopeInfo



class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {


    fun updateList(list: List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }


    //Crea la instancia del ViewHolder y la une con el xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }
    //Length al ViewHolder
    override fun getItemCount() = horoscopeList.size

    //Ordena al ViewHolder que editar
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }

}