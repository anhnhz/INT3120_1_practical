fun main() {
    val fPhone = FoldablePhone(isFolded = true)
    fPhone.switchOn()
    fPhone.checkPhoneScreenLight()
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(val isFolded: Boolean) : Phone(isScreenLightOn = false) {
    override fun switchOn() {
        if (!isFolded) isScreenLightOn = true
    }
}