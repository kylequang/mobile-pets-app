package com.example.s2k_petsapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s2k_petsapp.ui.theme.DeepBlue
import com.example.s2k_petsapp.ui.theme.LightPurple

@Composable
fun SignUp(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) // comeback
                    {
                        Icon( imageVector= Icons.Filled.ArrowBack, contentDescription = null, tint= Color.White)
                    }
                },
                modifier = Modifier.height(68.dp),
                title={ Text(text="Đăng Kí Nhận Nuôi", textAlign= TextAlign.Center, modifier= Modifier.fillMaxWidth())},
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
                    onClick = {},
                    Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    colors =  ButtonDefaults.buttonColors(backgroundColor = LightPurple),
                    elevation = ButtonDefaults.elevation(0.dp)
                ){
                    Text("Đăng Kí", style= MaterialTheme.typography.h5)
                }
            }
        },
        backgroundColor = DeepBlue,
        contentColor = Color.White
    )
    {

        Column(Modifier.fillMaxWidth()){
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                Modifier.padding(16.dp)
            ){
                val textFieldValue = remember{ mutableStateOf("") }
                TextField(
                    value = textFieldValue.value,
                    onValueChange = {value-> textFieldValue.value=value},
                    Modifier.fillMaxWidth(),
                    textStyle = TextStyle(
                        fontSize=24.sp,
                        color= Color.White
                    ),
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Nhập Họ Tên ",
                            color = Color.White
                        )
                    },
                    colors= TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorCursorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.White,
                    ),
                )
            }

            Row(
                Modifier.padding(16.dp)
            ){
                val textFieldValue = remember{ mutableStateOf("") }
                TextField(
                    value = textFieldValue.value,
                    onValueChange = {value-> textFieldValue.value=value},
                    Modifier.fillMaxWidth(),
                    textStyle = TextStyle(
                        fontSize=24.sp,
                        color= Color.White
                    ),
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Nhập Email",
                            color = Color.White
                        )
                    },
                    colors= TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorCursorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.White,
                    ),
                )
            }

            Row(
                Modifier.padding(16.dp)
            ){
                val textFieldValue = remember{ mutableStateOf("") }
                TextField(
                    value = textFieldValue.value,
                    onValueChange = {value-> textFieldValue.value=value},
                    Modifier.fillMaxWidth(),
                    textStyle = TextStyle(
                        fontSize=24.sp,
                        color= Color.White
                    ),
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Số Điện Thoại",
                            color = Color.White
                        )
                    },
                    colors= TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorCursorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.White,
                    ),
                )
            }
            Row(
                Modifier.padding(16.dp)
            ){
                val textFieldValue = remember{ mutableStateOf("") }
                TextField(
                    value = textFieldValue.value,
                    onValueChange = {value-> textFieldValue.value=value},
                    Modifier.fillMaxWidth(),
                    textStyle = TextStyle(
                        fontSize=24.sp,
                        color= Color.White
                    ),
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Địa chỉ",
                            color = Color.White
                        )
                    },
                    colors= TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorCursorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.White,
                    ),
                )
            }
        }

    }
}