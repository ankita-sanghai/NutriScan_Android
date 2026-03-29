package com.ankita.nutriscan.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpenFoodFactsSearchResponse(
    @Json(name = "products") val products: List<NetworkFood> = emptyList(),
    @Json(name = "count") val count: Int = 0,
    @Json(name = "page") val page: Int = 1,
    @Json(name = "page_size") val pageSize: Int = 20
)

@JsonClass(generateAdapter = true)
data class NetworkFood(
    @Json(name = "id") val id: String = "",
    @Json(name = "product_name") val productName: String? = null,
    @Json(name = "brands") val brands: String? = null,
    @Json(name = "image_url") val imageUrl: String? = null,
    @Json(name = "code") val barcode: String? = null,
    @Json(name = "nutriments") val nutriments: NetworkNutriments? = null,
    @Json(name = "serving_size") val servingSize: String? = null
)

@JsonClass(generateAdapter = true)
data class NetworkNutriments(
    @Json(name = "energy-kcal_100g") val caloriesPer100g: Float? = null,
    @Json(name = "proteins_100g") val proteinPer100g: Float? = null,
    @Json(name = "carbohydrates_100g") val carbsPer100g: Float? = null,
    @Json(name = "fat_100g") val fatPer100g: Float? = null,
    @Json(name = "fiber_100g") val fiberPer100g: Float? = null
)

@JsonClass(generateAdapter = true)
data class OpenFoodFactsProductResponse(
    @Json(name = "product") val product: NetworkFood? = null,
    @Json(name = "status") val status: Int = 0
)
