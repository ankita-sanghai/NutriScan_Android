package com.ankita.nutriscan.core.network.api

import com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponse
import com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenFoodFactsApi {

    @GET("cgi/search.pl")
    suspend fun searchFoods(
        @Query("search_terms") query: String,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 20,
        @Query("json") json: Int = 1,
        @Query("fields") fields: String = "id,product_name,brands,image_url,code,nutriments,serving_size"
    ): OpenFoodFactsSearchResponse

    @GET("api/v2/product/{barcode}")
    suspend fun getProductByBarcode(
        @Path("barcode") barcode: String,
        @Query("fields") fields: String = "id,product_name,brands,image_url,code,nutriments,serving_size"
    ): OpenFoodFactsProductResponse
}
