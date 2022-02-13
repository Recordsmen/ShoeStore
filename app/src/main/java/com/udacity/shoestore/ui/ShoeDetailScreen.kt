package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.ShoeListingScreenViewModel
import com.udacity.shoestore.databinding.ShoeDetailScreenBinding

class ShoeDetailScreen: Fragment() {
    private val viewModel: ShoeListingScreenViewModel by activityViewModels()

    lateinit var binding: ShoeDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_screen,container,false)
        binding.lifecycleOwner = this
        viewModel.resetNewShoe()
        binding.viewModel = viewModel

        binding.btnSave.setOnClickListener {
            if (viewModel.addNewShoe()) {
                it.findNavController().navigate(
                    ShoeDetailScreenDirections.actionShoeDetailScreenToShoeListingScreen()
                )
            } else {
                Snackbar.make(
                    requireView(),
                    getString(R.string.incomplete_text),
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }
        binding.btnCancel.setOnClickListener {
            it.findNavController().navigate(
                ShoeDetailScreenDirections.actionShoeDetailScreenToShoeListingScreen()
            )
        }
        return binding.root
    }
}

