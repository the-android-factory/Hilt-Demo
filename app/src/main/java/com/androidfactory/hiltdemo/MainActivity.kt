package com.androidfactory.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.androidfactory.hiltdemo.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var picassoUtil: PicassoUtil

    private val viewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.fetchNewImageUrl()
        }

        viewModel.imageUrlLiveData.observe(this) { imageUrl ->
            picassoUtil.loadImage(imageUrl, binding.imageView)
        }
    }
}