package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.art_space.ui.theme.Art_SpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Art_SpaceTheme {
                // A surface container using the 'background' color from the theme
                LayoutBasic()
            }
        }
    }
}
@Composable
fun LayoutBasic(modifier:Modifier=Modifier){
    val backgroundGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF7D7C7C), Color(0xFFB4B4B3)),
        start = Offset(100f, 300f),
        end = Offset(100f, 900f)
    )
    Box(
        modifier = Modifier.fillMaxSize()
            .background(brush=backgroundGradient),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FirstPart()
            SecondPart()
            ThirdPart()
        }
    }
}
@Composable
fun FirstPart(modifier:Modifier=Modifier){
        Image(
            painter = painterResource(id = R.drawable.trial_image),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 10.dp)
                .size(300.dp, 350.dp)
                .clip(RoundedCornerShape(20.dp))
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentScale = ContentScale.Crop
        )

}

@Composable
fun SecondPart(modifier:Modifier=Modifier){
    Column(
        modifier = modifier.padding(10.dp), // Use modifier as the receiver for padding
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = R.string.title),
            modifier = Modifier.padding(5.dp) // Use Modifier here for Text
        )
        Divider(
            color=Color.DarkGray,
            thickness = 3.dp,
            modifier = Modifier.fillMaxWidth(0.4f) // Use Modifier here for Divider
        )
        Text(
            stringResource(id = R.string.Artist1) + " ( " + stringResource(id = R.string.year) + " ) ",
            modifier = Modifier.padding(5.dp) // Use Modifier here for Text
        )
    }
}

@Composable
fun ThirdPart(modifier: Modifier=Modifier){
    Row(
        modifier.padding(10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.darkBlue)),
            modifier = modifier.size(150.dp,40.dp),
            elevation=ButtonDefaults.elevation(10.dp),
            shape= RoundedCornerShape(30.dp)
        ){
            Text(stringResource(id = R.string.previous))
        }
        Spacer(modifier.padding(30.dp,3.dp,30.dp,0.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor= colorResource(id=R.color.darkBlue)),
            modifier = modifier
                .size(150.dp,40.dp),

            elevation=ButtonDefaults.elevation(10.dp),
            shape= RoundedCornerShape(30.dp),

            ){
            Text(stringResource(id = R.string.next))
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    LayoutBasic()
}
