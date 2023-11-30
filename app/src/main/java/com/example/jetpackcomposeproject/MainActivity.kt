package com.example.jetpackcomposeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeproject.ui.theme.JetPackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                myApp()
            }
        }
    }

    @Composable
    fun myApp() {
        var moneyCounter = remember {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFF546E7A)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$${moneyCounter.value}", style = TextStyle(
                        color = Color.White,
                        fontSize = 120.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(150.dp))
                createCircle(moneyCounter = moneyCounter.value) {
                    moneyCounter.value = it + 1
                }
                if (moneyCounter.value > 3){
                    Text(text = "You are wealthy!!!",style =TextStyle(color = Color.Green,fontSize=40.sp,
                    fontFamily = FontFamily.Monospace))
                }
            }

        }
    }

    @Composable
    fun createCircle(moneyCounter : Int = 0, updateMoneyCounter : (Int)-> Unit) {

        Card(
            modifier = Modifier
                .padding(45.dp)
                .size(120.dp)
                .clickable {
                    updateMoneyCounter(moneyCounter)
                },
            shape = CircleShape,
            elevation = 5.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "Tap", modifier = Modifier)
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun defaultPreview() {
        JetPackComposeProjectTheme {
            myApp()
        }
    }


}