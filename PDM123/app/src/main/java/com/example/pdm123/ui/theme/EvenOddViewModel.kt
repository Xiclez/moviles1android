package com.example.pdm123.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

data class EvenOdd(val num: Int?)
class EvenOddViewModel : ViewModel() {
    private val evenOddState = MutableLiveData<String?>()
    fun getEvenOddState(): LiveData<String?> = evenOddState

    fun calculateEvenOdd(evenOdd: EvenOdd) {
        val number = evenOdd.num
        if (number == null) {
            evenOddState.postValue("Please type a number")
        } else if (number == 0) {
            evenOddState.postValue("Zero is even")
        } else if (number % 2 == 0) {
            evenOddState.postValue("Your number is even")
        } else if (number % 2 != 0) {
            evenOddState.postValue("Your number is odd")
        } else if (number < 0) {
            evenOddState.postValue("Please type an integer number")
        }
    }
}
