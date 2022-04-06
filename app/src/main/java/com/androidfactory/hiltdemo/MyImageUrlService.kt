package com.androidfactory.hiltdemo

import javax.inject.Inject

class MyImageUrlService @Inject constructor() {

    private val imageUrls = listOf(
        "https://images.freeimages.com/images/small-previews/a31/colorful-umbrella-1176220.jpg",
        "https://images.freeimages.com/images/small-previews/4d6/chugh-1171409.jpg",
        "https://images.freeimages.com/images/small-previews/934/antelope-canyon-6-1532993.jpg",
        "https://images.freeimages.com/images/small-previews/5f1/beach-resort-1395730.jpg",
        "https://images.freeimages.com/images/small-previews/6df/water-drop-on-leaf-1639205.jpg"
    )

    fun getImageUrl(): String {
        return imageUrls.random()
    }
}