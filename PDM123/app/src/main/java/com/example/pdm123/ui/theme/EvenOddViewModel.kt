package com.example.pdm123.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

data class EvenOdd(val num: Int)
class EvenOddViewModel : ViewModel() {
    private val evenOddState = MutableLiveData<Int>()
    fun getEvenOddState(): LiveData<Int> = evenOddState

    fun calculateEvenOdd(evenOdd: EvenOdd) {
        val number = evenOdd.num
        if (number == null) {
            evenOddState.postValue(R.string.even_odd_empty_state)
        } else if (number == 0) {
            evenOddState.postValue(R.string.zero_state)
        } else if (number % 2 == 0) {
            evenOddState.postValue(R.string.even_state)
        } else if (number % 2 != 0) {
            evenOddState.postValue(R.string.odd_state)
        } else if (number < 0) {
            evenOddState.postValue(R.string.even_odd_empty_state)
        }
    }
}

