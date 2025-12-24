package com.example.mentorly.Design.onboarding

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentorly.Design.data.OnBoardingPage
import com.example.mentorly.R
import com.example.mentorly.ui.theme.onBoardingBack
import com.example.mentorly.ui.theme.onBoardingCardBack
import com.example.mentorly.ui.theme.onBoardingDescText

import com.example.mentorly.ui.theme.onBoardingTittleText

@Composable
fun OnBoardingPageUI(page: OnBoardingPage){

    Column (
        modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
            .background(onBoardingBack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(page.image),
                contentDescription = null,
                modifier = Modifier.height(290.dp).width(375.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape= RoundedCornerShape(16.dp),
            colors= CardDefaults.cardColors(
                containerColor = onBoardingCardBack
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = page.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color=onBoardingTittleText,
                    fontFamily = FontFamily(
                        Font(
                            R.font.roboto,
                            weight = FontWeight.Normal
                        ))
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = page.description,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color=onBoardingDescText,
                     fontFamily = FontFamily(
                         Font(
                             R.font.roboto,
                             weight = FontWeight.Normal
                     ))
                )
            }
        }
        }

}
