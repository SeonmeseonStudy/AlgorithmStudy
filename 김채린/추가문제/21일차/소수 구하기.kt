import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().split(" ").map { it.toInt() }
    var arr = Array(n[1] + 1) { false }
    arr[0] = true
    arr[1] = true
    var i = 2
    while (i * i <= n[1]) {
        if (arr[i]) {
            i++
            continue
        }
        for (k in i * i..n[1] step i) {
            arr[k] = true
        }
        i++
    }
    for (j in n[0]..n[1]) {
        if (!arr[j]) println(j)
    }
}
