package unit1.pathway1

fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories")
}

fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val CALORIES_BURNED_FOR_EACH_STEP = 0.04
    val totalCaloriesBurned = numberOfSteps * CALORIES_BURNED_FOR_EACH_STEP
    return totalCaloriesBurned
}