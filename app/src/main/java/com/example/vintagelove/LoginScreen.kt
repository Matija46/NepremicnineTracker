package com.example.vintagelove

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.loginscreencomposeyt.MyTextField
import com.loc.loginscreencomposeyt.rememberImeState

@Composable
fun LoginScreen() {
    var isRegisterPage by remember { mutableStateOf(false) }
    val isImeVisible by rememberImeState()

    GradientBox(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val animatedUpperSectionRatio by animateFloatAsState(
                targetValue = if (isImeVisible) 0f else 0.35f,
                label = "",
            )

            AnimatedVisibility(visible = !isImeVisible, enter = fadeIn(), exit = fadeOut()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(animatedUpperSectionRatio),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Dobrodošli na nepremičnine tracker",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (isRegisterPage) "REGISTRACIJA" else "PRIJAVA",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(24.dp))

                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = if (isRegisterPage) "Uporabniško ime" else "Email",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions()
                )
                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = "Geslo",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions(),
                    trailingIcon = Icons.Default.Lock
                )

                if (isRegisterPage) {
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        label = "Potrdi Geslo",
                        keyboardOptions = KeyboardOptions(),
                        keyboardActions = KeyboardActions(),
                        trailingIcon = Icons.Default.Lock
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (isRegisterPage) {

                        } else {

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D4C92),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = if (isRegisterPage) "Registriraj se" else "Prijava",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight(500))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = { isRegisterPage = !isRegisterPage }) {
                    Text(
                        text = if (isRegisterPage) "Nazaj na prijavo" else "Nimate računa? Registracija",
                        color = MaterialTheme.colorScheme.primary,
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        }
    }
}
