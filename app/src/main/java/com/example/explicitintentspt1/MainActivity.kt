package com.example.explicitintentspt1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.explicitintentspt1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PersonViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBinding()
    }

    private fun initBinding() {
        activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)
        viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(PersonViewModel::class.java)
        activityMainBinding.vm = viewModel
        activityMainBinding.lifecycleOwner = this
    }
    fun moveToOtherActivity(view: View) {
        val nextIntent = Intent(this,
            MyOtherActivity::class.java).apply {
            putExtra(
                Details.FIRST_NAME.name,
                viewModel.firstName.get())
            putExtra(
                Details.SURNAME.name,
                viewModel.surname.get())
        }
        startActivity(nextIntent)
    }
}