package com.example.countryapphilt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapphilt.databinding.HomeRowBinding
import com.example.countryapphilt.model.DataList
import com.example.countryapphilt.util.loadImage
import com.example.countryapphilt.view.HomeFragmentDirections

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeAdapterClass>() {
    var dataListt= listOf<DataList>()

    fun setDataList(liveData:List<DataList>){
        this.dataListt=liveData
        notifyDataSetChanged()
    }

    class HomeAdapterClass(private val binding:HomeRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataList){
            binding.countryName.text= data.name!!.common
            binding.countryCapital.text=data.capital?.get(0).toString()
            binding.countryRegion.text=data.region.toString()
            binding.imageView.loadImage(data.flags.png)
           Log.e("comedata", data.translations?.tur?.common.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterClass {
        val infl=LayoutInflater.from(parent.context)
        val binding=HomeRowBinding.inflate(infl,parent,false)
        return HomeAdapterClass(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapterClass, position: Int) {
        val data=dataListt!!.get(position)
        holder.bind(data)
        holder.itemView.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun getItemCount() : Int {
        return dataListt.size
    }



}