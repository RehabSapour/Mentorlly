package com.example.mentorly.Design.onboarding

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentorly.ui.theme.SplashFirstColor
import com.example.mentorly.ui.theme.SplashSecondColor
import com.example.mentorly.R

@Preview
@Composable
fun SplachPreview(modifier: Modifier = Modifier) {
    SplashScreen()
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onSkipClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to SplashFirstColor,
                        0.6f to SplashFirstColor,
                        1.0f to SplashSecondColor
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        //  Bottom actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 28.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Skip
            Text(
                text = stringResource(R.string.skip),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { onSkipClick() }
            )

            // Arrow button
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .clickable { onNextClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = SplashFirstColor
                )
            }
        }

    }

}