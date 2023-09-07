package com.example.pdm123.ui.theme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

class CardsViewModel : ViewModel() {
    val cardImageResId = MutableLiveData(R.drawable.back)

    fun getRandomImage(): MutableLiveData<Int> = cardImageResId
    fun getRandomCard(){
        val randomNumber = (1..13).random()
            when (randomNumber){
                1-> cardImageResId.postValue(R.drawable.a)
                2->cardImageResId.postValue(R.drawable.c2)
                3->cardImageResId.postValue(R.drawable.c3)
                4->cardImageResId.postValue(R.drawable.c4)
                5->cardImageResId.postValue(R.drawable.c5)
                6->cardImageResId.postValue(R.drawable.c6)
                7->cardImageResId.postValue(R.drawable.c7)
                8->cardImageResId.postValue(R.drawable.c8)
                9->cardImageResId.postValue(R.drawable.c9)
                10->cardImageResId.postValue(R.drawable.c10)
                11->cardImageResId.postValue(R.drawable.j)
                12->cardImageResId.postValue(R.drawable.q)
                13->cardImageResId.postValue(R.drawable.k)
            }
    }

    fun showBackCard(){
        cardImageResId.postValue(R.drawable.back)
    }
}