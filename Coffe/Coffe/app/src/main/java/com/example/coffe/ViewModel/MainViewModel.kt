package com.example.coffe.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffe.Domain.BannerModel
import com.example.coffe.Domain.CategoryModel
import com.example.coffe.Domain.ItemsModel
import com.example.coffe.Repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository = MainRepository()
    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular():LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }

    fun loadItems(category:String):LiveData<MutableList<ItemsModel>>{
        return repository.loadItemCategory(category)
    }
}