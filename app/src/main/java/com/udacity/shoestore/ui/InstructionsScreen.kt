package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InsctructionsScreenBinding

class InstructionsScreen: Fragment(){
    private lateinit var binding: InsctructionsScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.insctructions_screen,container,false)
        binding.lifecycleOwner = this
        binding.btnNext.setOnClickListener{
            findNavController().navigate(InstructionsScreenDirections.actionInstructionsScreen2ToShoeListingScreen())
        }

        return binding.root
    }

}