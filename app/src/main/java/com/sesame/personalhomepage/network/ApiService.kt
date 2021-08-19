package com.sesame.personalhomepage.network

import com.sesame.personalhomepage.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>
}