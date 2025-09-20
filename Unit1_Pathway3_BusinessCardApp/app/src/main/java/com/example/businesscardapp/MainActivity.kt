package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                CenterView()
            }
        }
    }
}
@Composable
fun CardApp() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(220.dp))
        CenterView()

        BottomView()

    }
}

@Composable
fun CenterView() {
    Column (
        modifier = Modifier.fillMaxWidth().padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (Modifier.background(color = Color(0xFF000000))) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "android logo",
                Modifier.width(150.dp)
            )
        }
        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = "Lê Đức Hoàng Anh",
            fontSize = 34.sp,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = "Student of University of Engineering and Technology",
            fontWeight = FontWeight.Bold,
            color = Color(0xFE00FE00)
        )
    }
}

@Composable
fun BottomView(modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()

    ) {
        Column(
            modifier = modifier.fillMaxHeight().padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            InfoItem(icon = Icons.Filled.Call, text = "0123-456-789")
            InfoItem(icon = Icons.Filled.Share, text = "@anhnhz")
            InfoItem(icon = Icons.Filled.Email, text = "23020004@vnu.edu.vn")
        }
    }

}

@Composable
fun InfoItem(icon: ImageVector, text: String) {
    Row(

    ) {
        Icon(
            imageVector = icon, contentDescription = "",

        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text= text
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFD2E8D4)
@Composable
fun CardPreview() {
    CardApp()
}