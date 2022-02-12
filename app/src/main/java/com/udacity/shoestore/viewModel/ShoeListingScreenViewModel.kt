package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingScreenViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var newShoeName = "name"
    var newShoeSize = "2.2"
    var newCompanyName = "company"
    var newShoeDescription = "description"
    init {
        _shoeList.value = mutableListOf()
        mockData()
    }
    fun resetNewShoe() {
        newShoeName = ""
        newShoeSize = ""
        newCompanyName = ""
        newShoeDescription = ""
    }
    fun addNewShoe(): Boolean {
        if (!validateNewShoeInputs()) return false
        addShoe(
            newShoeName,
            newShoeSize.toDouble(),
            newCompanyName,
            newShoeDescription
        )

        return true
    }
    private fun mockData() {
            addShoe("Shoe", 7.0, "Company", "Shoe Description")
    }
    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }
    private fun validateNewShoeInputs(): Boolean {
        if (newShoeName.isBlank() ||
            newCompanyName.isBlank() ||
            newShoeSize.isBlank()  ||
            newShoeDescription.isBlank()) {

            return false
        }

        return true
    }


}