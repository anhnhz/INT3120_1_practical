package com.example.a30_days_app.model

import com.example.a30_days_app.R

data class Exercise (
    val name: String,
    val descriptionRes: Int,
    val imageRes: Int,
)


object ExerciseRepository {
    val exercises = listOf(
        Exercise(
            name = "Day 1",
            descriptionRes = R.string.description_1,
            imageRes = R.drawable.exercise_01
        ),
        Exercise(
            name = "Day 2",
            descriptionRes = R.string.description_2,
            imageRes = R.drawable.exercise_02
        ),
        Exercise(
            name = "Day 3",
            descriptionRes = R.string.description_3,
            imageRes = R.drawable.exercise_03
        ),
        Exercise(
            name = "Day 4",
            descriptionRes = R.string.description_4,
            imageRes = R.drawable.exercise_04
        ),
        Exercise(
            name = "Day 5",
            descriptionRes = R.string.description_5,
            imageRes = R.drawable.exercise_05
        ),
        Exercise(
            name = "Day 6",
            descriptionRes = R.string.description_6,
            imageRes = R.drawable.exercise_06
        ),
        Exercise(
            name = "Day 7",
            descriptionRes = R.string.description_7,
            imageRes = R.drawable.exercise_07
        ),
        Exercise(
            name = "Day 8",
            descriptionRes = R.string.description_8,
            imageRes = R.drawable.exercise_08
        ),
        Exercise(
            name = "Day 9",
            descriptionRes = R.string.description_9,
            imageRes = R.drawable.exercise_09
        ),
        Exercise(
            name = "Day 10",
            descriptionRes = R.string.description_10,
            imageRes = R.drawable.exercise_10
        ),
        Exercise(
            name = "Day 11",
            descriptionRes = R.string.description_11,
            imageRes = R.drawable.exercise_11
        ),
        Exercise(
            name = "Day 12",
            descriptionRes = R.string.description_12,
            imageRes = R.drawable.exercise_12
        ),
        Exercise(
            name = "Day 13",
            descriptionRes = R.string.description_13,
            imageRes = R.drawable.exercise_13
        ),
        Exercise(
            name = "Day 14",
            descriptionRes = R.string.description_14,
            imageRes = R.drawable.exercise_14
        ),
        Exercise(
            name = "Day 15",
            descriptionRes = R.string.description_15,
            imageRes = R.drawable.exercise_15
        ),
        Exercise(
            name = "Day 16",
            descriptionRes = R.string.description_16,
            imageRes = R.drawable.exercise_16
        ),
        Exercise(
            name = "Day 17",
            descriptionRes = R.string.description_17,
            imageRes = R.drawable.exercise_17
        ),
        Exercise(
            name = "Day 18",
            descriptionRes = R.string.description_18,
            imageRes = R.drawable.exercise_18
        ),
        Exercise(
            name = "Day 19",
            descriptionRes = R.string.description_19,
            imageRes = R.drawable.exercise_19
        ),
        Exercise(
            name = "Day 20",
            descriptionRes = R.string.description_20,
            imageRes = R.drawable.exercise_20
        ),
        Exercise(
            name = "Day 21",
            descriptionRes = R.string.description_21,
            imageRes = R.drawable.exercise_21
        ),
        Exercise(
            name = "Day 22",
            descriptionRes = R.string.description_22,
            imageRes = R.drawable.exercise_22
        ),
        Exercise(
            name = "Day 23",
            descriptionRes = R.string.description_23,
            imageRes = R.drawable.exercise_23
        ),
        Exercise(
            name = "Day 24",
            descriptionRes = R.string.description_24,
            imageRes = R.drawable.exercise_24
        ),
        Exercise(
            name = "Day 25",
            descriptionRes = R.string.description_25,
            imageRes = R.drawable.exercise_25
        ),
        Exercise(
            name = "Day 26",
            descriptionRes = R.string.description_26,
            imageRes = R.drawable.exercise_26
        ),
        Exercise(
            name = "Day 27",
            descriptionRes = R.string.description_27,
            imageRes = R.drawable.exercise_27
        ),
        Exercise(
            name = "Day 28",
            descriptionRes = R.string.description_28,
            imageRes = R.drawable.exercise_28
        ),
        Exercise(
            name = "Day 29",
            descriptionRes = R.string.description_29,
            imageRes = R.drawable.exercise_29
        ),
        Exercise(
            name = "Day 30",
            descriptionRes = R.string.description_30,
            imageRes = R.drawable.exercise_30
        )
    )
}