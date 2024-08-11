import java.io.BufferedReader

fun suger(num: Int): Int {
    var five = num / 5
    while (five >= 0) {
        if ((num - five * 5) % 3 == 0) {
            return five + (num - (5 * five)) / 3
        }
        five--
    }
    return -1
}

fun main() {
    val br = BufferedReader(System.`in`.reader())
    println(suger(br.readLine().toInt()))
    br.close()
}
