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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import java.time.Year

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
fun LayoutBasic(){
    var currentIndex by remember{ mutableStateOf(0) }

    var artworks=listOf(
        artspaceinfo(R.drawable.trial_image, R.string.title1, R.string.Artist1, R.string.year1),
        artspaceinfo(R.drawable.surfboard, R.string.title2, R.string.Artist2, R.string.year2),
        artspaceinfo(R.drawable.randomgirl, R.string.title3, R.string.Artist3, R.string.year3)
    )

    var currentArtwork=artworks[currentIndex]
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
            FirstPart(currentArtwork.artwork)
            SecondPart(currentArtwork.title,currentArtwork.artist , currentArtwork.year)
            ThirdPart(currentIndex,artworks.size){
                newIndex->currentIndex=newIndex
            }
        }
    }
}
data class artspaceinfo(
    var artwork:Int,
    var title:Int,
    var artist:Int,
    var year:Int
)

/*
@Composable

fun Change(count:Int,modifier: Modifier= Modifier,){
    /*
    var artworkImage by remember{ mutableStateOf(R.drawable.trial_image) }
    var titleName by remember{ mutableStateOf(R.string.title) }
    var artistName by remember{ mutableStateOf(R.string.Artist1) }
    var year by remember{ mutableStateOf(R.string.year) }
    */
    when(count){
        1->{
            LayoutBasic(

                R.drawable.trial_image,
                R.string.title1,
                R.string.Artist1,
                R.string.year1,
            )
        }
        2->{
            LayoutBasic(

            R.drawable.surfboard,
            R.string.title2,
            R.string.Artist2,
            R.string.year2,
            )
        }
        3->{
            LayoutBasic(

            R.drawable.randomgirl,
            R.string.title3,
            R.string.Artist3,
            R.string.year3,
            )
        }
    }
}

 */

@Composable
fun FirstPart(Artwork:Int, modifier: Modifier =Modifier){
        Image(
            painter = painterResource(Artwork),
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
fun SecondPart(Title:Int, Artist: Int,Year: Int,modifier:Modifier=Modifier){

    Column(
        modifier = modifier.padding(10.dp), // Use modifier as the receiver for padding
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(Title),
            modifier = Modifier.padding(5.dp) // Use Modifier here for Text
        )
        Divider(
            color=Color.DarkGray,
            thickness = 3.dp,
            modifier = Modifier.fillMaxWidth(0.4f) // Use Modifier here for Divider
        )
        Text(
            stringResource(Artist) + " ( " + stringResource(Year) + " ) ",
            modifier = Modifier.padding(5.dp) // Use Modifier here for Text
        )
    }
}

@Composable
fun ThirdPart(currentIndex: Int, totalArtworks: Int,modifier: Modifier=Modifier,onIndexChanged: (Int) -> Unit){
  // var correntartworkIndex by remember{ mutableStateOf(currentIndex) }
    Row(
        modifier.padding(10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(
            onClick = {
                      if(currentIndex>0){
                          onIndexChanged(currentIndex-1)
                      }
            },
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
            onClick = {
                if (currentIndex < totalArtworks - 1) {
                    onIndexChanged(currentIndex + 1)
                }
                      },
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
    LayoutBasic(  )
}
