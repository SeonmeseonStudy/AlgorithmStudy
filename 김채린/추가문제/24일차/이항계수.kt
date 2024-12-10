import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    print(sol(nums[0], nums[1]))
}

fun sol(
    s: Int,
    e: Int,
): Int {
    if (e == 0 || s == e) {
        return 1
    }
    if (s - e < e) return sol(s, s - e)
    var h = 1
    var d = 1
    for (i in 1..e) {
        h *= (s - i + 1)
        d *= i
    }
    return h / d
}
