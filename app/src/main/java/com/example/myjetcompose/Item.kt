package com.example.myjetcompose

import androidx.annotation.DrawableRes

data class Item(
    var title:String,
    @DrawableRes val image: Int
)
