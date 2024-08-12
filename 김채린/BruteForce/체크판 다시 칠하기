import java.io.*
import kotlin.math.*

var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums =
        br
            .readLine()
            .trim()
            .split(" ")
            .filter { it != "" }
            .map { it.toInt() }
    n = nums[0]
    m = nums[1]
    val arr = Array(n) { Array(m) { "" } }
    for (i in 0 until n) {
        arr[i] =
            br
                .readLine()
                .trim()
                .split("")
                .filter { it != "" }
                .toTypedArray()
    }

    var minChanges = Int.MAX_VALUE
    for (i in 0..n - 8) {
        for (j in 0..m - 8) {
            val copy1 = Array(arr.size) { arr[it].clone() }
            val copy2 = Array(arr.size) { arr[it].clone() }
            minChanges = min(minChanges, sol(i, j, copy1, "W"))
            minChanges = min(minChanges, sol(i, j, copy2, "B"))
        }
    }

    println(minChanges)
}

fun sol(
    x: Int,
    y: Int,
    arr: Array<Array<String>>,
    startColor: String,
): Int {
    var count = 0
    for (i in x .. x + 7) {
        for (j in y .. y + 7) {
            val color =
                if ((i + j) % 2 == 0) {
                    startColor
                } else if (startColor == "W") {
                    "B"
                } else {
                    "W"
                }
            if (arr[i][j] != color) {
                count++
            }
        }
    }
    return count
}
