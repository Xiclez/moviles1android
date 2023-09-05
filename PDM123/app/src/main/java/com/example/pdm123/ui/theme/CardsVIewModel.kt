package com.example.pdm123.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import com.example.pdm123.R

class CardsViewModel : ViewModel() {
    val cardImageResId = MutableLiveData(R.drawable.back)

    fun getRandomImage(): MutableLiveData<Int> = cardImageResId
    fun getRandomCard(){
        val randomNumber = Random.nextInt(1,14)
            when (randomNumber){
                1-> cardImageResId.postValue(R.drawable.A)
                2->cardImageResId.postValue(R.drawable.c2)
                3->cardImageResId.postValue(R.drawable.c3)
                4->cardImageResId.postValue(R.drawable.c4)
                5->cardImageResId.postValue(R.drawable.c5)
                6->cardImageResId.postValue(R.drawable.c6)
                7->cardImageResId.postValue(R.drawable.c7)
                8->cardImageResId.postValue(R.drawable.c8)
                9->cardImageResId.postValue(R.drawable.c9)
                10->cardImageResId.postValue(R.drawable.c10)
                11->cardImageResId.postValue(R.drawable.J)
                12->cardImageResId.postValue(R.drawable.Q)
                13->cardImageResId.postValue(R.drawable.K)
            }
    }

    fun showBackCard(){
        cardImageResId.postValue(R.drawable.back)
    }
}