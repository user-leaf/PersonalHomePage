package com.sesame.personalhomepage.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sesame.personalhomepage.model.User
import com.sesame.personalhomepage.network.RetrofitUtils
import com.sesame.personalhomepage.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    val userLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    init {
        repository = UserRepository(application, RetrofitUtils.getApiService())
        getDataFromApi()
    }

    fun getDataFromApi() {
        repository.requestFromApi("user-leaf", userLiveData)
    }
}