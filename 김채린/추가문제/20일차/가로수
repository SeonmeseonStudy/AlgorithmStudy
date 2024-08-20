import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var arr = mutableListOf<Int>()
    for (i in 1..n) {
        arr.add(br.readLine().toInt())
    }
    var s = mutableListOf<Int>()
    for (i in 0 until n - 1) {
        s.add(arr[i + 1] - arr[i])
    }
    var newS = s.distinct().toMutableList()
    while (newS.size > 1) {
        newS[0] = sol(newS[0], newS[1])
        newS.removeAt(1)
    }
    var count = 0
    for (i in s) {
        count += i / newS[0] - 1
    }
    print(count)
}

fun sol(
    a: Int,
    b: Int,
): Int {
    if (a % b == 0) return b
    return sol(b, a % b)
}
