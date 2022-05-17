package com.codinginflow.simplecachingexample.data

import androidx.room.withTransaction
import com.codinginflow.simplecachingexample.api.RestaurantApi
import com.codinginflow.simplecachingexample.util.networkBoundResources
import kotlinx.coroutines.delay
import javax.inject.Inject

//video 4 38:30
class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResources(
        query = {
            restaurantDao.getAllRestaurant()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}