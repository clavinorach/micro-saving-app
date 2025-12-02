package com.example.microsaving.model

data class SavingGoal(
    val id: String,
    val name: String,
    val targetAmount: Long,
    val currentAmount: Long,
    val dueDate: String? = null
) {
    val progressPercent: Float
        get() = if (targetAmount > 0) (currentAmount.toFloat() / targetAmount).coerceIn(0f, 1f) else 0f

    val progressPercentInt: Int
        get() = (progressPercent * 100).toInt()

    val remainingAmount: Long
        get() = (targetAmount - currentAmount).coerceAtLeast(0)
}
