package com.example.s2k_petsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.example.s2k_petsapp.R
import com.example.s2k_petsapp.data.PetData
import com.example.s2k_petsapp.data.PetList
import com.example.s2k_petsapp.ui.theme.DeepBlue
import com.example.s2k_petsapp.ui.theme.LightBlue


@Composable
fun HomeScreen(navController: NavController){
    Scaffold() {
        Box(
            modifier = Modifier
                .background(DeepBlue)
                .padding(24.dp)
                .fillMaxSize()
        ){
            LazyColumn(){
                item{
                    Header() // call Header()
                    Spacer(modifier = Modifier.height(24.dp))
                    SearchField()
                    Spacer(modifier = Modifier.height(24.dp))
                    Text("Danh sách thú thất lạc", style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    ) )
                    Spacer( Modifier.height(12.dp))
                }
                items(PetList.size){ //lặp duyệt listof
                        item-> PetsListItem(item = PetList[item],
                    onCardClick ={
                        item->navController.navigate("details/${item.id-1}") // navigate to detail
                    } )
                }
            }
        }
    }
}

@Composable
fun Header(name:String="Bạn"){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Column(verticalArrangement=Arrangement.Center){
            Text(
                text="Chào mừng, $name đến với ứng dụng",
                style= MaterialTheme.typography.h2,
                fontWeight = FontWeight.Bold,
                fontSize=20.sp,
                color= Color.White
            )
            Text(
                text="Nhận nuôi thú thất lạc tại ĐÂY!",
                style= MaterialTheme.typography.body1,
                color= Color.White
            )
        }
        
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_pets_24),
            contentDescription = "Pet icon",
            tint = Color.White,
            modifier = Modifier.size(32.dp)

        )
    }
}

@Composable
fun SearchField(){
    val textFieldValue = remember{ mutableStateOf("")}
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
                text = "Tìm kiếm Pets ",
                color = Color.White
            )
        },
        leadingIcon = {
            Icon (
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search Icon Button",
                tint = Color.White,
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

@Composable
fun PetsListItem(item:PetData,onCardClick:(PetData)->Unit){
 Card(backgroundColor = LightBlue,
     modifier = Modifier
         .fillMaxWidth()
         .padding(bottom = 16.dp)
         .clip(RoundedCornerShape(size = 8.dp))
         .background(LightBlue)
         .clickable(onClick = { onCardClick(item) }, enabled = true)
         .padding(12.dp),
     elevation = 0.dp
         ){
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
         PetDetails(age = item.age, weight = item.weight )
     }
 }
}

@Composable
fun PetDetails(age:Int,weight:Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Column(
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ) {
            val year= if(age>1) "Years" else "Year"
            Text("Age", style = TextStyle(
                color=Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
              textAlign = TextAlign.Center
            )
            Text("$age $year", textAlign = TextAlign.Center, color=Color(0xFFdfdfdf))
        }
        Column(
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ) {
            val year= if(age>1) "Years" else "Year"
            Text("Weight", style = TextStyle(
                color=Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
                textAlign = TextAlign.Center
            )
            Text("$weight Kg", textAlign = TextAlign.Center, color=Color(0xFFdfdfdf))
        }
    }
}