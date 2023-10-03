package com.example.pdm123.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

data class OnBoardingData(val image: Int, val title: String, val desc: String)


@Composable
fun LoaderIntro(modifier: Modifier, image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier.fillMaxSize()
    )
}