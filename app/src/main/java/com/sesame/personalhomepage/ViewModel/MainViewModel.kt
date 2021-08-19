package com.sesame.personalhomepage.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sesame.personalhomepage.model.User
import com.sesame.personalhomepage.network.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val userLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    fun getData(){
        val user = RetrofitUtils.getApiService().getUser("user-leaf")
        user.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    userLiveData.postValue(response.body())
                }else{
                    Toast.makeText(getApplication(), "fail", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(getApplication(), "onFailure", Toast.LENGTH_SHORT).show()
            }
        })

    }
}