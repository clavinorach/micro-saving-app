package com.example.microsaving.model

object DummyData {

    fun getDummyGoals(): List<SavingGoal> = listOf(
        SavingGoal(
            id = "goal_1",
            name = "Headphone Baru",
            targetAmount = 1_500_000,
            currentAmount = 850_000,
            dueDate = "15 Jan 2026"
        ),
        SavingGoal(
            id = "goal_2",
            name = "Dana Darurat",
            targetAmount = 10_000_000,
            currentAmount = 3_250_000,
            dueDate = null
        ),
        SavingGoal(
            id = "goal_3",
            name = "Liburan ke Bali",
            targetAmount = 5_000_000,
            currentAmount = 1_200_000,
            dueDate = "20 Mar 2026"
        ),
        SavingGoal(
            id = "goal_4",
            name = "Laptop Baru",
            targetAmount = 15_000_000,
            currentAmount = 4_500_000,
            dueDate = "1 Jun 2026"
        ),
        SavingGoal(
            id = "goal_5",
            name = "Hadiah Ulang Tahun",
            targetAmount = 500_000,
            currentAmount = 350_000,
            dueDate = "25 Des 2025"
        )
    )

    fun getDummyContributionsFor(goalId: String): List<SavingContribution> {
        return when (goalId) {
            "goal_1" -> listOf(
                SavingContribution("c1", goalId, 100_000, "1 Des 2025", "Tabungan harian"),
                SavingContribution("c2", goalId, 250_000, "28 Nov 2025", "Bonus mingguan"),
                SavingContribution("c3", goalId, 50_000, "25 Nov 2025", null),
                SavingContribution("c4", goalId, 200_000, "20 Nov 2025", "Hasil freelance"),
                SavingContribution("c5", goalId, 250_000, "15 Nov 2025", "Setoran awal")
            )
            "goal_2" -> listOf(
                SavingContribution("c6", goalId, 500_000, "1 Des 2025", "Transfer bulanan"),
                SavingContribution("c7", goalId, 750_000, "1 Nov 2025", "Transfer bulanan"),
                SavingContribution("c8", goalId, 1_000_000, "1 Okt 2025", "Bonus gaji"),
                SavingContribution("c9", goalId, 1_000_000, "1 Sep 2025", "Setoran awal")
            )
            "goal_3" -> listOf(
                SavingContribution("c10", goalId, 300_000, "30 Nov 2025", "Hemat dari kopi"),
                SavingContribution("c11", goalId, 400_000, "15 Nov 2025", "Tabungan akhir pekan"),
                SavingContribution("c12", goalId, 500_000, "1 Nov 2025", "Mulai menabung")
            )
            "goal_4" -> listOf(
                SavingContribution("c13", goalId, 1_500_000, "25 Nov 2025", "Pembayaran proyek"),
                SavingContribution("c14", goalId, 1_000_000, "10 Nov 2025", "Tabungan bulanan"),
                SavingContribution("c15", goalId, 2_000_000, "20 Okt 2025", "Setoran awal")
            )
            "goal_5" -> listOf(
                SavingContribution("c16", goalId, 150_000, "1 Des 2025", "Tabungan cepat"),
                SavingContribution("c17", goalId, 200_000, "20 Nov 2025", "Mulai merencanakan")
            )
            else -> emptyList()
        }
    }
}
