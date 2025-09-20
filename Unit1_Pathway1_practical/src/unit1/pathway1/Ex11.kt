package unit1.pathway1

fun main() {
    printInfo("Ankara", 27, 31, 82);
    printInfo("Tokyo", 32, 36, 10);
    printInfo("CapeTown", 59, 64, 20);
    printInfo("Guatemala City", 50, 55, 7);
}

fun printInfo(city: String, lowTemp: Int, highTemp: Int, rainChancePercentage: Int) {
    println("City: $city")
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    println("Chance of rain: $rainChancePercentage%")
    println()
}