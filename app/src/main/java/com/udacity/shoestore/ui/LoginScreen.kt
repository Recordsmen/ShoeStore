package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginScreenBinding

class LoginScreen : Fragment() {
    private lateinit var binding:LoginScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = LoginScreenBinding.inflate(layoutInflater,container,false)
        binding.lifecycleOwner = this
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        binding.btnLogin.setOnClickListener{
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToWelcomeScreen(email,password))
        }
        binding.btnSignIn.setOnClickListener{
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToWelcomeScreen(email,password))
        }

        return binding.root
    }


}