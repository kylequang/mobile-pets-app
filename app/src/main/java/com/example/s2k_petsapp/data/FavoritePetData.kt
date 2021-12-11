package com.example.s2k_petsapp.data

data class  FavoritePet(
    val id:Int,
    val name: String,
    val sex: String,
    val age: Int,
    val weight: Double,
    val imagePath: Int,
    val category: String
)
val FavoritePetData = mutableListOf<FavoritePet>(
)