package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BusinessCardTheme {
                        BusinessCard()
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF99a3dd)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PersonCard()
            InformCard()
        }
    }
}

@Composable
fun PersonCard(
    modifier: Modifier = Modifier,
    name: String = stringResource(id = R.string.name),
    vocation: String = stringResource(id = R.string.vocation)
) {
    val image = painterResource(id = R.drawable.new_busy_cut)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(270.dp)
                .border(
                    BorderStroke(4.dp, Color(0xFF380187)),
                    CircleShape
                )
                .clip(CircleShape),
            painter = image,
            contentDescription = name,
            contentScale = ContentScale.Crop
        )
        Text(
            text = name,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF380187),
            style = TextStyle(
                fontSize = 56.sp,
            ),
        )
        Text(
            text = vocation,
            textAlign = TextAlign.Justify,
            color = Color(0xFF7f0001),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    text: String,
    image: ImageVector
) {
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
       Icon(
           imageVector = image,
           contentDescription = text,
           tint = Color(0xFF380187),
           modifier = Modifier
               .weight(1f)
               .padding(start = 40.dp)
               .size(19.dp)
       )
        Text(
            text = text,
            textAlign = TextAlign.Left,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(4f)
        )
    }
}

@Composable
fun InformCard(
    modifier: Modifier = Modifier,
    email: String = stringResource(id = R.string.email),
    phone: String = stringResource(id = R.string.phone),
    share: String = stringResource(id = R.string.share)
) {
    Column(modifier = modifier) {
        ContactCard(
            text = phone,
            image = Icons.Rounded.Phone
        )
        ContactCard(
            text = share,
            image = Icons.Rounded.Share
        )
        ContactCard(
            text = email,
            image = Icons.Rounded.Email
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}