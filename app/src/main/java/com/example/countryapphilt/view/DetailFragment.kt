package com.example.countryapphilt.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.countryapphilt.R
import com.example.countryapphilt.databinding.FragmentDetailBinding
import com.example.countryapphilt.databinding.FragmentHomeBinding
import com.example.countryapphilt.util.loadImage


class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()
    private lateinit var binding:FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //DataBinding ekledim
        args?.let {
            binding.country=it.datalist
        }

        val data=args.datalist.capital?.get(0)
//        binding.countryCapital.text="Capital:"+data.toString()
//        binding.countryPopulation.text="Population"+args.datalist.population.toString()
//        binding.countryRegion.text="Region:"+args.datalist.region.toString()
//        binding.countrySubRegion.text="SubRegion:"+args.datalist.subregion.toString()
//        binding.countryTimeZone.text="TimeZone:"+args.datalist.timezones?.get(0)
//        binding.detailCountryName.text=args.datalist.name?.official.toString()

        binding.countryLatiLongi.text="LatiLongi:"+"${args.datalist.latlng?.get(0).toString().toDouble()} "+" ${args.datalist.latlng?.get(1).toString().toDouble()}"
        binding.countryCapitalLatiLongi.text="Capital LatiLong:"+"${args.datalist.capitalInfo?.latlng?.get(0)} "+" ${args.datalist.capitalInfo?.latlng?.get(1).toString()}"
        binding.detailImage.loadImage(args.datalist.flags.png)

//        binding.ara.text="Ara : ${args.datalist.translations?.ara?.official}"
//        binding.Tur.text="Tur : ${args.datalist.translations?.tur?.official}"
//        binding.bre.text="Bre : ${args.datalist.translations?.bre?.official}"
//        binding.ces.text="Ces : ${args.datalist.translations?.ces?.official}"
//        binding.cym.text="Cym : ${args.datalist.translations?.cym?.official}"
//        binding.deu.text="Deu : ${args.datalist.translations?.deu?.official}"
//        binding.est.text="Est : ${args.datalist.translations?.est?.official}"
//        binding.fin.text="Fin : ${args.datalist.translations?.fin?.official}"
//        binding.fra.text="Fra : ${args.datalist.translations?.fra?.official}"
//        binding.hrv.text="Hrv : ${args.datalist.translations?.hrv?.official}"
//        binding.hun.text="Hun : ${args.datalist.translations?.hun?.official}"
//        binding.ita.text="Ita : ${args.datalist.translations?.ita?.official}"
//        binding.jpn.text="Jpn : ${args.datalist.translations?.jpn?.official}"
//        binding.kor.text="Kor : ${args.datalist.translations?.kor?.official}"
//        binding.nld.text="Nld : ${args.datalist.translations?.nld?.official}"
//        binding.per.text="Per : ${args.datalist.translations?.per?.official}"
//        binding.pol.text="Pol : ${args.datalist.translations?.pol?.official}"
//        binding.por.text="Por : ${args.datalist.translations?.por?.official}"
//        binding.rus.text="Rus : ${args.datalist.translations?.rus?.official}"
//        binding.slk.text="Slk : ${args.datalist.translations?.slk?.official}"
//        binding.spa.text="Spa : ${args.datalist.translations?.spa?.official}"
//        binding.swe.text="Swe : ${args.datalist.translations?.swe?.official}"
//        binding.urd.text="Urd : ${args.datalist.translations?.urd?.official}"
//        binding.zho.text="Zho : ${args.datalist.translations?.zho?.official}"

    }

}