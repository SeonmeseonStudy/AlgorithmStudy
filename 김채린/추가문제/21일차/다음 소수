import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        var num = br.readLine().toLong()
        if (num < 2) {
            println(2)
            continue
        }

        while (true) {
            var count = 0
            for (j in 2..sqrt(num.toDouble()).toInt()) {
                if (num % j == 0L) {
                    count++
                    break
                }
            }
            if (count == 0) {
                println(num)
                break
            }
            num++
        }
    }
}
