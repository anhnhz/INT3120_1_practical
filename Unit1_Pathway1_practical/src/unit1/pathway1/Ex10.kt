package unit1.pathway1

fun main() {
    val timeSpentToday = 300
    val timeSpentYesterday = 250

    println(timeCompare(timeSpentToday,timeSpentYesterday))
}

fun timeCompare(timeSpentToday: Int, timeSpentYesterday: Int):Boolean {
    return timeSpentToday > timeSpentYesterday;
}