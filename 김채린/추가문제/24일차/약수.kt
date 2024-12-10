import java.io.*
import java.util.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = 0
    var min = Int.MAX_VALUE
    if (n > 0) {
        val nums = br.readLine().split(" ").map { it.toInt() }
        for (i in nums) {
            max = max(max, i)
            min = min(min, i)
        }
    }
        println(max*min)
}
