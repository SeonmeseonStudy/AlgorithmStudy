import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[1]) { 0 }
    sol(n[0], 0, n[1], arr, sb, 1)
    print(sb.toString())
}

fun sol(
    n: Int,
    count: Int,
    end: Int,
    arr: Array<Int>,
    sb: StringBuilder,
    now: Int,
) {
    if (count == end) {
        for (i in arr) {
            sb.append("$i ")
        }
        sb.append("\n")
        return
    }
    for (i in now..n) {
        arr[count] = i
        sol(n, count + 1, end, arr, sb, i)
    }
}
