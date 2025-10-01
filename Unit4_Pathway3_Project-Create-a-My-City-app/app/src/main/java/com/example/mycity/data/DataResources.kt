package com.example.mycity.data

import com.example.mycity.model.Location
import com.example.mycity.R

object DataResources {

    fun getCafeList(): List<Location> {
        return listOf(
            Location(
                nameResId = R.string.placename_cafe_1,
                descriptionResId = R.string.description_cafe_1,
                imageResId = R.drawable.defaut_location_img
            ),
            Location(
                nameResId = R.string.placename_cafe_2,
                descriptionResId = R.string.description_cafe_2,
                imageResId = R.drawable.defaut_location_img
            ),
            Location(
                nameResId = R.string.placename_cafe_3,
                descriptionResId = R.string.description_cafe_3,
                imageResId = R.drawable.defaut_location_img
            ),
            Location(
                nameResId = R.string.placename_cafe_4,
                descriptionResId = R.string.description_cafe_4,
                imageResId = R.drawable.defaut_location_img
            )
        )
    }

    fun getRestaurantList(): List<Location> {
        return listOf(
            Location(R.string.placename_restaurant_1, R.string.description_restaurant_1, R.drawable.defaut_location_img),
            Location(R.string.placename_restaurant_2, R.string.description_restaurant_2, R.drawable.defaut_location_img),
            Location(R.string.placename_restaurant_3, R.string.description_restaurant_3, R.drawable.defaut_location_img),
            Location(R.string.placename_restaurant_4, R.string.description_restaurant_4, R.drawable.defaut_location_img)
        )
    }

    fun getKidsList(): List<Location> {
        return listOf(
            Location(R.string.placename_kids_1, R.string.description_kids_1, R.drawable.defaut_location_img),
            Location(R.string.placename_kids_2, R.string.description_kids_2, R.drawable.defaut_location_img),
            Location(R.string.placename_kids_3, R.string.description_kids_3, R.drawable.defaut_location_img),
            Location(R.string.placename_kids_4, R.string.description_kids_4, R.drawable.defaut_location_img)
        )
    }

    fun getParkList(): List<Location> {
        return listOf(
            Location(R.string.placename_park_1, R.string.description_park_1, R.drawable.defaut_location_img),
            Location(R.string.placename_park_2, R.string.description_park_2, R.drawable.defaut_location_img),
            Location(R.string.placename_park_3, R.string.description_park_3, R.drawable.defaut_location_img),
            Location(R.string.placename_park_4, R.string.description_park_4, R.drawable.defaut_location_img)
        )
    }

    fun getMallList(): List<Location> {
        return listOf(
            Location(R.string.placename_mall_1, R.string.description_mall_1, R.drawable.defaut_location_img),
            Location(R.string.placename_mall_2, R.string.description_mall_2, R.drawable.defaut_location_img),
            Location(R.string.placename_mall_3, R.string.description_mall_3, R.drawable.defaut_location_img),
            Location(R.string.placename_mall_4, R.string.description_mall_4, R.drawable.defaut_location_img),
            Location(R.string.placename_mall_5, R.string.description_mall_5, R.drawable.defaut_location_img)
        )
    }

    fun getAllCategoryNameId() : List<Int> {
        return listOf(
            R.string.category_1,
            R.string.category_2,
            R.string.category_3,
            R.string.category_4,
            R.string.category_5,
        )
    }
}
