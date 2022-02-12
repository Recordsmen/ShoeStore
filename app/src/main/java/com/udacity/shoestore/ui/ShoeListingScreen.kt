package com.udacity.shoestore.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.ShoeListingScreenViewModel
import com.udacity.shoestore.databinding.ShoeListingScreenBinding
import kotlinx.android.synthetic.main.item_shoe.view.*


class ShoeListingScreen: Fragment(){

    private lateinit var binding: ShoeListingScreenBinding

    private val viewModel: ShoeListingScreenViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ShoeListingScreenBinding.inflate(layoutInflater,container,false)
        binding.lifecycleOwner = this
        binding.addShoeButton.setOnClickListener{
            this.findNavController().navigate(ShoeListingScreenDirections.actionShoeListingScreenToShoeDetailScreen())
        }
        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addShoe(shoe.name,shoe.size,shoe.company,shoe.description)
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.logout, menu)
    }
    @SuppressLint("ResourceType")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> findNavController().navigate(ShoeListingScreenDirections.actionShoeListingScreenToLoginScreen())
        }

        return super.onOptionsItemSelected(item)
    }
    @SuppressLint("InflateParams")
    private fun addShoe(shoeName: String, size: Double,company: String, description: String) {
        val view = layoutInflater.inflate(R.layout.item_shoe, null)
        view.tv_shoe_name.text = shoeName
        view.tv_shoe_company.text = company
        view.tv_shoe_size.text = size.toString()
        view.tv_shoe_discription.text = description
        binding.shoeList.addView(view.rootView)
    }

}