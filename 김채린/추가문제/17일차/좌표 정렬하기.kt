/*
5
3 4
1 1
1 -1
2 2
3 3
*/
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var arr = Array(n) { Array(2) { 0 } }
    for (i in 0 until n) {
        arr[i] =
            br
                .readLine()
                .split(" ")
                .map { it.toInt() }
                .toTypedArray()
    }
    arr.sortWith { a, b ->
        if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0]
    }

    for (i in arr) {
        println("${i[0]} ${i[1]}")
    }
}
