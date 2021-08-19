package com.sesame.personalhomepage

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sesame.personalhomepage.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainViewModel by viewModels()

        model.userLiveData.observe(this, {
            Glide.with(this).load(it.avatar_url).into(ivHead)
            tvLocation.text = "location: ${it.location}"
        })

        model.getData()
    }
}
