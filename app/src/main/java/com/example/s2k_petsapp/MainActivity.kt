package com.example.s2k_petsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.s2k_petsapp.data.PetList
import com.example.s2k_petsapp.ui.screen.*
import com.example.s2k_petsapp.ui.theme.S2KPetsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S2KPetsAppTheme {
                MyApp() // call fun MyApp()
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController=navController,startDestination="home"){ // Bắt đâu bằng trang home
    composable(route = "home"){
        HomeScreen(navController)
    }
        composable("details/{dogIndex}", arguments = listOf(navArgument("dogIndex"){
            type= NavType.IntType })){
            val dogIndex= it.arguments?.getInt("dogIndex")  ?:0

            DetailScreen(navController, petData = PetList[dogIndex])
        }

        composable("signup"){
                SignUp(navController)
        }
        composable("favorite/{dogIndex}",arguments = listOf(navArgument("dogIndex"){
            type= NavType.IntType })){
            val dogIndex= it.arguments?.getInt("dogIndex")  ?:0
            FavoritePets(navController, petData = PetList[dogIndex])
        }
    }
}

