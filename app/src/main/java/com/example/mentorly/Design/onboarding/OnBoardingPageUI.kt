package com.example.mentorly.Design.onboarding

import androidx.compose.ui.res.stringResource
import com.example.mentorly.Design.data.OnBoardingPage
import com.example.mentorly.R

val pages = listOf(
    OnBoardingPage(
        image = R.drawable.img,
        title = R.string.onboard_title_welcome,
        description = R.string.onboard_desc_welcome
    ),
    OnBoardingPage(
        image = R.drawable.img_1,
        title = R.string.onboard_title_guidance,
        description = R.string.onboard_desc_guidance
    ),
    OnBoardingPage(
        image = R.drawable.img_2,
        title = R.string.onboard_title_learning,
        description = R.string.onboard_desc_learning
    )
)

