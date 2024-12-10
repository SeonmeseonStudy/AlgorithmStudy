import java.io.*
import java.util.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val limit = 1000000
    var arr = BooleanArray(limit + 1) { true }
    var a = 2
    arr[0] = false
    arr[1] = false
    while (a <= sqrt(limit.toDouble())) {
        if (!arr[a]) {
            a++
            continue
        }
        for (j in a * a..limit step a) {
            arr[j] = false
        }
        a++
    }
    for (i in 0 until n) {
        val num = br.readLine().toInt()
        if (num == 2) {
            println(0)
            continue
        }
        var count = 0
        for (j in 2..num / 2) {
            if (arr[j] && arr[num - j]) {
                count++
            }
        }
        println(count)
    }
}
