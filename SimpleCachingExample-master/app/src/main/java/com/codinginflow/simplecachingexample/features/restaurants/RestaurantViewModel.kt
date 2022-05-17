package com.codinginflow.simplecachingexample.features.restaurants

import androidx.lifecycle.*
import com.codinginflow.simplecachingexample.api.RestaurantApi
import com.codinginflow.simplecachingexample.data.Restaurant
import com.codinginflow.simplecachingexample.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()

       /* private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
        val restaurants : LiveData<List<Restaurant>> = restaurantLiveData

    init {//video 3 11:00 re-watch
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            delay(2000)
            restaurantLiveData.value = restaurants
        }
    }*/

}