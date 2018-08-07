package com.amiibos.service

import com.amiibos.model.AmiiboResponse
import retrofit2.Call
import retrofit2.http.GET

interface AmiiboService {
    @GET("amiibo/?type=figure")
    fun getAmiibos() : Call<AmiiboResponse>
}