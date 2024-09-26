package com.example.listexample.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Plant(
    @DrawableRes val imageResId: Int,
    @StringRes val nameResId: Int,
    @StringRes val scNameResId: Int,
    @StringRes val descriptionResId: Int,
    @StringRes val sourceResId: Int,
)
