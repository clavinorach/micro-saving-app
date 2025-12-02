package com.example.microsaving.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.microsaving.model.DummyData
import com.example.microsaving.model.SavingContribution
import com.example.microsaving.model.SavingGoal
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class SavingViewModel : ViewModel() {

    private val _goals = mutableStateListOf<SavingGoal>().apply {
        addAll(DummyData.getDummyGoals())
    }
    val goals: List<SavingGoal> get() = _goals

    private val _contributions = mutableStateMapOf<String, MutableList<SavingContribution>>().apply {
        DummyData.getDummyGoals().forEach { goal ->
            this[goal.id] = DummyData.getDummyContributionsFor(goal.id).toMutableList()
        }
    }

    val totalSaved: Long
        get() = _goals.sumOf { it.currentAmount }

    val activeGoalsCount: Int
        get() = _goals.size

    val topGoals: List<SavingGoal>
        get() = _goals.sortedByDescending { it.progressPercent }.take(3)

    val allContributions: List<Pair<SavingContribution, String>>
        get() {
            val result = mutableListOf<Pair<SavingContribution, String>>()
            _goals.forEach { goal ->
                val contributions = _contributions[goal.id] ?: emptyList()
                contributions.forEach { contribution ->
                    result.add(Pair(contribution, goal.name))
                }
            }
            return result.sortedByDescending { it.first.timestamp }
        }

    fun getGoalById(id: String): SavingGoal? {
        return _goals.find { it.id == id }
    }

    fun getContributionsFor(goalId: String): List<SavingContribution> {
        return _contributions[goalId] ?: emptyList()
    }

    fun addContribution(goalId: String, amount: Long, note: String?) {
        val goalIndex = _goals.indexOfFirst { it.id == goalId }
        if (goalIndex == -1) return

        val currentGoal = _goals[goalIndex]
        val updatedGoal = currentGoal.copy(
            currentAmount = currentGoal.currentAmount + amount
        )
        _goals[goalIndex] = updatedGoal

        val now = Date()
        val dateFormat = SimpleDateFormat("d MMM yyyy, HH:mm", Locale("id", "ID"))
        val contribution = SavingContribution(
            id = UUID.randomUUID().toString(),
            goalId = goalId,
            amount = amount,
            date = dateFormat.format(now),
            timestamp = now.time,
            note = note?.takeIf { it.isNotBlank() }
        )

        val contributionList = _contributions.getOrPut(goalId) { mutableListOf() }
        contributionList.add(0, contribution)
        _contributions[goalId] = contributionList
    }

    fun addGoal(name: String, targetAmount: Long, dueDate: String?) {
        val newGoal = SavingGoal(
            id = UUID.randomUUID().toString(),
            name = name,
            targetAmount = targetAmount,
            currentAmount = 0,
            dueDate = dueDate?.takeIf { it.isNotBlank() }
        )
        _goals.add(0, newGoal)
        _contributions[newGoal.id] = mutableListOf()
    }

    fun resetAllData() {
        _goals.clear()
        _goals.addAll(DummyData.getDummyGoals())

        _contributions.clear()
        DummyData.getDummyGoals().forEach { goal ->
            _contributions[goal.id] = DummyData.getDummyContributionsFor(goal.id).toMutableList()
        }
    }
}
