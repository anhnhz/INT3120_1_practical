package unit1.pathway1

fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
}

// Define your displayAlertMessage() below this line.
fun displayAlertMessage(opSystem: String, emailId: String): String {
    return "There's a new sign-in request on $opSystem for your Google Account $emailId."
}