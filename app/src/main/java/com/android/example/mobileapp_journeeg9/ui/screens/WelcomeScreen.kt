package com.example.journee.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.journee.ui.theme.Purple

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(60.dp))
        Text("Journée", fontSize = 36.sp, color = Color.Black)

        Spacer(Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .padding(24.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    repeat(3) { index ->
                        Box(
                            Modifier
                                .size(8.dp)
                                .padding(4.dp)
                                .background(
                                    if (index == 0) Color.White else Color.LightGray,
                                    shape = CircleShape
                                )
                        )
                    }
                }

                Text(
                    "Welcome to Journee",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .widthIn(max = 280.dp)
                        .padding(top = 16.dp)
                )

                Text(
                    "Let's start a life with a memorable Journee!",
                    color = Color.White,
                    modifier = Modifier
                        .widthIn(max = 280.dp)
                        .padding(top = 8.dp)
                )

                Spacer(Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate("register") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Continue", color = Purple)
                }
            }
        }
    }
}
