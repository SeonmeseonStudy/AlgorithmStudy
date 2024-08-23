import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val nums = br.readLine().split(" ").map { it.toInt() }
        if (nums[0] == nums[1]) {
            println(1)
            continue
        }
        println(sol(nums[0], nums[1]))
    }
}

fun sol(
    num: Int,
    num2: Int,
): Long {
    if (num > num2 - num) {
        return sol(num2 - num, num2)
    }
    var count = 1L
    for (i in 0 until num) {
        count *= (num2 - i)
        count /= (1 + i)
    }
    return count
}
