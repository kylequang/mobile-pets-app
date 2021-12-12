package com.example.s2k_petsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s2k_petsapp.data.*
import com.example.s2k_petsapp.ui.theme.DeepBlue


@Composable
fun FavoritePets(navController: NavController,petData: PetData){


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() })
                    {
                        Icon( imageVector= Icons.Filled.ArrowBack, contentDescription = null, tint= Color.White)
                    }
                },
                modifier = Modifier.height(68.dp),
                title={ Text(text="Danh sách thú cưng yêu thích", textAlign= TextAlign.Center, modifier= Modifier.fillMaxWidth())},
                elevation=0.dp,
                backgroundColor = DeepBlue,
                contentColor = Color.White,
            )

        },

        backgroundColor = DeepBlue,
        contentColor = Color.White
    )
    {
        addToListFavoritePet( petData = petData)

        Spacer(modifier = Modifier.height(50.dp))
        LazyColumn(){

            items(FavoritePetData.size){ //lặp duyệt listof
                    item-> showPet(item = FavoritePetData[item])
            }
        }
    }
}
@Composable
fun addToListFavoritePet(petData : PetData){

    var pet= FavoritePet(petData.id,petData.name,petData.sex,petData.age, petData.weight, petData.imagePath, petData.category);

    LazyColumn(){

        if(FavoritePetData.size == 0){
            FavoritePetData.add(pet)
        }else{
            var count=0;
            for (i in 0 until FavoritePetData.size) {
                if(pet.id === FavoritePetData[i].id)
                {
                    break;
                }else{
                   count++;
                }
            }
            if(count === FavoritePetData.size){
                FavoritePetData.add(pet);
            }
        }
    }
}



@Composable
fun showPet(item:FavoritePet){

        Column(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color.Gray),
                Alignment.Center)
            {
                Image(painter= painterResource(id = item.imagePath),
                    contentDescription= null,
                    contentScale = ContentScale.Crop,
                    modifier=Modifier.fillMaxSize())
            }
            Spacer(modifier= Modifier.height(4.dp))
            Text(item.name,style= TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            )

        }

}