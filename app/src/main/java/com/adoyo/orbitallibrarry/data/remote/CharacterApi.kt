package com.adoyo.orbitallibrarry.data.remote

import com.adoyo.orbitallibrarry.model.PageInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("pageSize") pageCount: Int,
        @Query("page") page: Int
    ): ApiResponse

    companion object {
        const val BASE_URL = "https://api.disneyapi.dev/"
    }
}


data class ApiResponse(val info: PageInfo, val data: List<CharacterDto>)
