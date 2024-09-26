package com.example.listexample.data

import com.example.listexample.R
import com.example.listexample.model.Plant

class DataSource {
    fun loadPlants(): List<Plant> {
        return listOf<Plant>(
            Plant(R.drawable.flor, R.string.plant1, R.string.sc1, R.string.description1, R.string.reference),
            Plant(R.drawable.flor, R.string.plant2, R.string.sc2, R.string.description2, R.string.reference),
            Plant(R.drawable.flor, R.string.plant3, R.string.sc3, R.string.description3, R.string.reference),
            Plant(R.drawable.flor, R.string.plant4, R.string.sc4, R.string.description4, R.string.reference),
            Plant(R.drawable.flor, R.string.plant5, R.string.sc5, R.string.description5, R.string.reference),
            Plant(R.drawable.flor, R.string.plant6, R.string.sc6, R.string.description6, R.string.reference),
            Plant(R.drawable.flor, R.string.plant7, R.string.sc7, R.string.description7, R.string.reference),
            Plant(R.drawable.flor, R.string.plant8, R.string.sc8, R.string.description8, R.string.reference),
            Plant(R.drawable.flor, R.string.plant9, R.string.sc9, R.string.description9, R.string.reference),
            Plant(R.drawable.flor, R.string.plant10, R.string.sc10, R.string.description10, R.string.reference)

        )
    }
}