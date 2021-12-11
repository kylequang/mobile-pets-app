package com.example.s2k_petsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.s2k_petsapp.data.PetData
import com.example.s2k_petsapp.ui.theme.DeepBlue
import com.example.s2k_petsapp.ui.theme.LightBlue
import com.example.s2k_petsapp.ui.theme.LightPurple


@Composable
fun DetailScreen123() {
    Text("hihihihi")
}


@Composable
fun DetailScreen(navController: NavController, petData: PetData){
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
                title={ Text(text="Tiến Hành Nhận Nuôi", textAlign= TextAlign.Center, modifier=Modifier.fillMaxWidth())},
                
                actions={
                    IconButton(onClick = {navController.navigate("favorite/${petData.id-1}") }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null,tint=Color.White)
                    }                    
                }   ,
                elevation=0.dp,
                backgroundColor = DeepBlue,
                contentColor = Color.White,
            )

        },
        bottomBar={
            Row(
                Modifier.padding(16.dp)
            ){
                Button(
                    onClick = { navController.navigate("signup") },
                    Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    colors =  ButtonDefaults.buttonColors(backgroundColor = LightPurple),
                    elevation = ButtonDefaults.elevation(0.dp)
                ){
                    Text("Nhận nuôi", style= MaterialTheme.typography.h5)
                }
            }
        },
        backgroundColor = DeepBlue,
        contentColor = Color.White
    )
    {

        Body(Modifier.padding(16.dp), petData = petData)
    }
}

@Composable
fun Body(modifier: Modifier, petData: PetData){
 Column(modifier=modifier){
     Box(
         Modifier
             .fillMaxWidth()
             .height(280.dp)
             .clip(shape = RoundedCornerShape(8.dp))

     ){
         Image(painter = painterResource(id = petData.imagePath),
             contentDescription=null,
         contentScale= ContentScale.Crop,
         modifier = Modifier.fillMaxSize())
     }
     Spacer(modifier=Modifier.height(12.dp))
     Text(petData.name, style= MaterialTheme.typography.h4)
     Spacer(modifier=Modifier.height(12.dp))
     Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        val mod= Modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .weight(1f)
            .background(LightBlue)
            .padding(all = 8.dp)
         DetailsBox(title = "Gender", infor = "${petData.sex}", mod )
         Spacer(modifier=Modifier.width(6.dp))
         DetailsBox(title = "Age", infor = "${petData.age}", mod )
         Spacer(modifier=Modifier.width(6.dp))
         DetailsBox(title = "Weight", infor = "${petData.weight}", mod )
         Spacer(modifier=Modifier.width(6.dp))
     }


     Spacer(modifier=Modifier.height(12.dp))
     Text("Tổng quan về ${petData.name}", style= MaterialTheme.typography.h4)

     Spacer(modifier=Modifier.height(12.dp))
     Text("Một chú chó dễ thương và rất ngoan hiền ", style= MaterialTheme.typography.body2)
  }
}

@Composable
fun DetailsBox(title:String, infor:String, modifier: Modifier){
    Box(modifier = modifier){
        Column(){
            Text(text=title,Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(text=infor,Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}






