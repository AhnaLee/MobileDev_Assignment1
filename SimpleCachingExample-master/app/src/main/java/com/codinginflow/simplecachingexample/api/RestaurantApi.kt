package com.codinginflow.simplecachingexample.api

import com.codinginflow.simplecachingexample.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20") //TO GET LIST OF 20 RESTAURANT
    suspend fun getRestaurants(): List<Restaurant>
}