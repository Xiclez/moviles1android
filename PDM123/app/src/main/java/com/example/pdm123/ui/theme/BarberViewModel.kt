package com.example.pdm123.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class BarberViewModel : ViewModel() {

    val countCut = MutableLiveData(0)
    val countBeard = MutableLiveData(0)
    val countCnB = MutableLiveData(0)
    val total = MutableLiveData(0)

    fun getCutCount(): LiveData<Int> = countCut
    fun getBeardCount(): LiveData<Int> = countBeard
    fun getCutAndBeard(): LiveData<Int> = countCnB
    fun getTotal(): LiveData<Int> = total

    fun addCut() {
        val currentCut = countCut.value ?: 0
        countCut.value = currentCut + 1
        calculateTotal()
    }

    fun addBeard() {
        val currentBeard = countBeard.value ?: 0
        countBeard.value = currentBeard + 1
        calculateTotal()
    }

    fun addCutnBeard() {
        val currentCnB = countCnB.value ?: 0
        countCnB.value = currentCnB + 1
        calculateTotal()
    }

    private fun calculateTotal() {
        val cutCost = (countCut.value ?: 0) * 150
        val beardCost = (countBeard.value ?: 0) * 250
        val cnbCost = (countCnB.value ?: 0) * 500

        val totalCost = cutCost + beardCost + cnbCost
        total.value = totalCost
    }
}
