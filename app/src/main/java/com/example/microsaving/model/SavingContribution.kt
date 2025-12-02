package com.example.microsaving.model

data class SavingContribution(
    val id: String,
    val goalId: String,
    val amount: Long,
    val date: String,
    val note: String? = null
)
