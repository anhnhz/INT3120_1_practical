fun main() {
    val a: Song = Song("Noi Vong Tay Lon", "Trinh Cong Son", "1975", 99009900)
    a.printDescription()
}

class Song(
    var title: String,
    var artist: String,
    var publishYear: String,
    var playCount: Int,
) {
    val isPopular: Boolean
        get() = playCount >= 1000;

    fun printDescription() {
        println("$title, performed by $artist, was released in $publishYear.")
    }
}