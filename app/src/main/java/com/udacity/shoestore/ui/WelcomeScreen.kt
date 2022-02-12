package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeScreenBinding

class WelcomeScreen:Fragment() {
    lateinit var binding: WelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_screen,container,false)
        binding.btnNext.setOnClickListener{
            findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructionsScreen2())
        }

        return binding.root
    }

}