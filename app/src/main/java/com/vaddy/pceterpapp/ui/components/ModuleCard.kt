package com.vaddy.pceterpapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vaddy.pceterpapp.data.ModuleNames


@Composable
fun Module(
    module: ModuleNames
){
    Card(
        modifier = Modifier
            .height(210.dp)
            .width(100.dp)
            .padding(8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        elevation = CardDefaults.cardElevation(12.dp),
        shape =  RoundedCornerShape(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(243, 238, 238, 255))
            ,

            ) {

            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                drawCircle(
                    color = Color(0xFFC6D2ED),
                    radius = 300f,
                    center = Offset(223f,70f)
                )
            }


            Column(
                modifier = Modifier.fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(7.dp))
                Text(
                    text = module.name,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Card(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(0.3f.dp, Color.Black, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = module.icon),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
    }
}