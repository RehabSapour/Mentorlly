package com.example.mentorly.Design.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentorly.Design.data.OnBoardingPageModel
import com.example.mentorly.R
import com.example.mentorly.ui.theme.SplashFirstColor
import com.example.mentorly.ui.theme.onBoardingBack
import com.example.mentorly.ui.theme.onBoardingCardBack
import com.example.mentorly.ui.theme.onBoardingDescText

import com.example.mentorly.ui.theme.onBoardingTittleText

@Composable
fun OnBoardingPageUI(page: OnBoardingPageModel, pagerState: PagerState, onFinish: () -> Unit){

    Column (
        modifier = Modifier
        .fillMaxSize()
            .background(onBoardingBack)
        .padding(24.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

           Text(
               text = "Mentorly",
               fontSize =36.sp,
               fontWeight = FontWeight.SemiBold,
               fontFamily = FontFamily(Font(
                   R.font.roboto,
                   weight = FontWeight.Normal
               )),
               style = TextStyle(
                   shadow = Shadow(
                       color = Color.Gray.copy(alpha = 0.5f),
                       offset = Offset(3f, 3.5f),
                       blurRadius = 8f
                   )
               ),
               color = SplashFirstColor
           )

            Image(
                painter = painterResource(page.image),
                contentDescription = null,
                modifier = Modifier.height(290.dp).width(375.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp).height(300.dp).width(343.dp),
            shape= RoundedCornerShape(16.dp),
            colors= CardDefaults.cardColors(
                containerColor = onBoardingCardBack
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource( page.title),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
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
                    text = stringResource( page.description),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color=onBoardingDescText,
                     fontFamily = FontFamily(
                         Font(
                             R.font.roboto,
                             weight = FontWeight.Normal
                     ))
                )
                Spacer(modifier = Modifier.height(16.dp))

                BottomSection(
                    pagerState = pagerState,
                    onFinish = onFinish
                )

            }
        }
        }

}

val pages = listOf(
    OnBoardingPageModel(
        image = R.drawable.img,
        title = R.string.onboard_title_welcome,
        description = R.string.onboard_desc_welcome
    ),
    OnBoardingPageModel(
        image = R.drawable.img_1,
        title = R.string.onboard_title_guidance,
        description = R.string.onboard_desc_guidance
    ),
    OnBoardingPageModel(
        image = R.drawable.img_2,
        title = R.string.onboard_title_learning,
        description = R.string.onboard_desc_learning
    )
)
