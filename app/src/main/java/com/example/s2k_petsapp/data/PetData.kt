package com.example.s2k_petsapp.data

import com.example.s2k_petsapp.R

data class  PetData(
    val id:Int,
    val name: String,
    val sex: String,
    val age: Int,
    val weight: Double,
    val imagePath: Int,
    val category: String
)
val PetList = mutableListOf<PetData>(
    PetData(1,"LiLi","Male",2,3.2, R.drawable.pet1,"Thỏ"),
    PetData(2,"Lu Lu","Female",2,3.0, R.drawable.pet2,"Chó"),
    PetData(3,"Cậu Vàng","Female",2,1.5, R.drawable.pet3,"Mèo"),
    PetData(4,"Bống","Male",2,3.2, R.drawable.pet4,"Chó vs Mèo"),
    PetData(5,"He","Male",2,2.5, R.drawable.pet5,"Chó vs Mèo"),
    PetData(6,"Tom","Female",2,5.1, R.drawable.pet6,"Mèo"),
    PetData(7,"Hảo Hảo","Male",2,4.2, R.drawable.pet7,"Chó"),
    PetData(8,"Chú 3","Female",2,4.2, R.drawable.pet8,"Chó"),
    PetData(9,"Lo Lo","Male",2,3.2, R.drawable.pet9,"Chó"),
    PetData(10,"Ten Ten","Male",2,3.6, R.drawable.pet10,"Chó"),
)