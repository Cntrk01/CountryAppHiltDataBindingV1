package com.example.countryapphilt.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapphilt.R
import com.example.countryapphilt.adapter.HomeAdapter
import com.example.countryapphilt.databinding.FragmentHomeBinding
import com.example.countryapphilt.model.DataList
import com.example.countryapphilt.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(),defaultViewModelProviderFactory).get(HomeViewModel::class.java)
    }
    private lateinit var homeAdapter:HomeAdapter
    private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter= HomeAdapter()
        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter=homeAdapter
        observeLiveData()
    }

    private fun observeLiveData(){
        with(viewModel){
            data.observe(requireActivity(), Observer {
                it?.let {
                    binding.recyclerView.visibility=View.VISIBLE
                    homeAdapter.setDataList(it)
                }
//              binding.recyclerView.visibility=View.VISIBLE
            })
            progresBar.observe(requireActivity(), Observer {
                it?.let {
                    if(it){
                        binding.progresBar.visibility=View.VISIBLE
                        binding.errorText.visibility=View.GONE
                        binding.recyclerView.visibility=View.GONE
                    }
                   else{
                        binding.progresBar.visibility=View.GONE
                        //binding.recyclerView.visibility=View.VISIBLE
                    }
                //    handleViews(it)
                }
            })
            errorMessage.observe(requireActivity(), Observer {
               it?.let {
                   if(it){
                       binding.errorText.visibility=View.VISIBLE
                   }else{
                       binding.errorText.visibility=View.GONE
                   }
               }
            })
        }
    }
}