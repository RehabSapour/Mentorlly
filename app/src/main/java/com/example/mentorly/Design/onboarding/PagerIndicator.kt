package com.example.mentorly.Design.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mentorly.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    pagerState: PagerState
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(pagerState.pageCount) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(if (pagerState.currentPage == index) 10.dp else 8.dp)
                    .background(
                        if (pagerState.currentPage == index)
                            Color.Black
                        else
                            Color.Gray,
                        CircleShape
                    )
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomSection(
    pagerState: PagerState,
    onFinish: () -> Unit
) {
    Column() {

        PagerIndicator(pagerState)

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                if (pagerState.currentPage == pagerState.pageCount - 1) {
                    onFinish()
                }
            }
        ) {
            Text(
                text = if (pagerState.currentPage == pagerState.pageCount - 1)
                    stringResource(id = R.string.get_started)
                else
                    stringResource(id = R.string.next)
            )
        }
    }
}

