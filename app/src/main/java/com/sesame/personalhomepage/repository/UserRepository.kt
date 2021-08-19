package com.sesame.personalhomepage.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.sesame.personalhomepage.model.User
import com.sesame.personalhomepage.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    val application: Application,
    private val apiService: ApiService
) {

    fun requestFromApi(
        user: String,
        liveData: MutableLiveData<User>
    ) {
        apiService.getUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(application, "onFailure", Toast.LENGTH_SHORT).show()
            }
        })
    }

}