package com.example.microsaving.model

data class SavingContribution(
    val id: String,
    val goalId: String,
    val amount: Long,
    val date: String,
    val timestamp: Long = System.currentTimeMillis(),
    val note: String? = null
)
