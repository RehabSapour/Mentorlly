package com.example.mentorly.Design.Role

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.mentorly.R
import com.example.mentorly.ui.theme.SplashFirstColor
import com.example.mentorly.ui.theme.SplashSecondColor
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush




//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MentorshipOnboardingScreen(selectRole: () -> Unit) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier.height(160.dp).width(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        // 2. Heading
        Text(
            text = "Select your role to get started",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(
                R.font.roboto
            )),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray.copy(alpha = 0.5f),
                    offset = Offset(-2.0f, 3.5f),
                    blurRadius = 8f
                )
            ),
            color = SplashFirstColor,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        // 3. Role Selection Cards
        RoleCard3(
            title = "Mentor",
            description = "Share Knowledge, guide others",
            imageRes = R.drawable.mentor, // استبدلي بالصورة المناسبة
            isSelected = selectedRole == "Mentor",
        ) {
            selectedRole = "Mentor"
        }

        Spacer(modifier = Modifier.height(16.dp))

        RoleCard3(
            title = "Student",
            description = "Learn. Grow. Succeed",
            imageRes = R.drawable.student, // استبدلي بالصورة المناسبة
            isSelected = selectedRole == "Student",
        ) {
            selectedRole = "Student"
        }

        Spacer(modifier = Modifier.padding(14.dp))

        // 5. Continue Button
        Button(
            onClick = {
                selectRole()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SplashFirstColor),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(text = "Continue", fontSize = 18.sp, color = Color.White)
        }
    }
}
@Composable
fun RoleCard3(
    title: String,
    description: String,
    imageRes: Int,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    // Scale animation based on selection
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.05f else 1f,
        animationSpec = spring()
    )

    // Background gradient: لو مختارة gradient ملون، لو مش مختارة لون أزرق فاتح ثابت
    val backgroundBrush = if (isSelected) {
        Brush.horizontalGradient(listOf(SplashFirstColor, SplashSecondColor))
    } else {
        Brush.horizontalGradient(listOf(Color.White, Color.White)) // أزرق فاتح ثابت
    }

    // Border: يظهر لو مش مختارة، يختفي لو مختارة
    val borderStroke = if (!isSelected) BorderStroke(3.dp,SplashSecondColor) else null

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .scale(scale)
            .clickable { onSelect() },
        shape = RoundedCornerShape(16.dp),
        border = borderStroke,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(brush = backgroundBrush)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                // Title + Description
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = if(isSelected) Color.White else SplashSecondColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = if(isSelected) Color.White else Color.Gray

                    )
                }

                // Circular image
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}


