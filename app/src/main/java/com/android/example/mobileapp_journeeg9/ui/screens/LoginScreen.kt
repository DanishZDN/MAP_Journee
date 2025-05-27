package com.example.journee.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.journee.ui.theme.Gray
import com.example.journee.ui.theme.Purple

@Composable
fun LoginScreen(navController: NavController) {
    Column(Modifier.padding(24.dp)) {
        Text("Login", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Log back in to enjoy the fullest of your life upgrades!")

        Spacer(Modifier.height(16.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email Address") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(16.dp))
        Button(onClick = { /* TODO: Sign in */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign In")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Divider(Modifier.weight(1f))
            Text("  ii  ", color = Gray)
            Divider(Modifier.weight(1f))
        }

        Button(onClick = { navController.navigate("register") }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Don't have an account? Make one!", color = Purple, modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}
