package com.example.pdm123.ui.theme
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdm123.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun OnboardingView(){
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.drawable.breadboard,
            "Title 1",
            "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.smiling_man,
            "Title 2",
            "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.ingenieriamecatronica,
            "Title 3",
            "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."
        )
    )
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    )
}
@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    /* Image(
                         painter = painterResource(id = item[page].image),
                         contentDescription = item[page].title,
                         modifier = Modifier
                             .height(250.dp)
                             .fillMaxWidth()
                     )*/
                    LoaderIntro(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),item[page].image)
                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.Black,
                        style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                    )

                    Text(
                        text = item[page].desc,
                        modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
                        color = Color.Black,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(pagerState.currentPage, pagerState)
        }
    }
}
@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(
    saver = PagerState.Saver
) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.Red else Blue200.copy(alpha = 0.5f)
            )
    )
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(currentPager: Int, pagerState: PagerState) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 2) {
            OutlinedButton(
                onClick = { /* Action on Login button click */ },
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = "Login", // Cambia el texto de "Get Started" a "Login"
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Blue200
                )
            }

            OutlinedButton(
                onClick = { /* Action on Register button click */ },
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = "Register", // Nuevo botón con el texto "Register"
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Blue200
                )
            }
        } else {
            SkipNextButton(text = "Skip", modifier = Modifier.padding(start = 20.dp), pagerState)
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp), pagerState)
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipNextButton(text: String, modifier: Modifier, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Text(
        text = text,
        color = Color.Black,
        modifier = modifier.clickable {
            if (text == "Skip") {
                // Cambiar a la última página al hacer clic en "Skip"
                val lastPage = pagerState.pageCount - 1
                if (lastPage >= 0) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(lastPage)
                    }
                }
            } else if (text == "Next") {
                // Cambiar a la siguiente página al hacer clic en "Next"
                val nextPage = pagerState.currentPage + 1
                if (nextPage < pagerState.pageCount) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(nextPage)
                    }
                }
            }
        },
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Medium
    )
}