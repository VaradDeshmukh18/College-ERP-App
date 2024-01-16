package com.vaddy.pceterpapp.mainUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CircNameCard(){
    Card(
        modifier = Modifier
            .clip(CircleShape)
            .size(50.dp)
    ) {
        Column (
            modifier = Modifier
                .size(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF02002a),
                            Color(0xFF070762),
                            Color(0xFF0420c5)
                        )
                    )
                )

            ,

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "VD",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}