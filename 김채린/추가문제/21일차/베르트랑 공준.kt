import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        var n = br.readLine().toInt()
        if (n == 0) break
        var arr = Array(2 * n + 1) { false }
        arr[0] = true
        arr[1] = true
        var i = 2
        while (i * i <= 2 * n) {
            if (arr[i]) {
                i++
                continue
            }
            for (k in i * i..2 * n step i) {
                arr[k] = true
            }
            i++
        }
        var count = 0
        for (j in n + 1..2 * n) {
            if (!arr[j]) count++
        }
        println(count)
    }
}
