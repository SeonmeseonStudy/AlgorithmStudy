import java.io.*
import java.util.*

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var arr = Array(0) { IntArray(0) }
var visited = Array(0) { Array(0) { false } }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    arr = Array(nums[0]) { IntArray(nums[1]) }
    visited = Array(nums[0]) { Array(nums[1]) { false } }
    for (i in 0 until nums[0]) {
        arr[i] =
            br
                .readLine()
                .split("")
                .filter { !it.equals("") }
                .map { it.toInt() }
                .toIntArray()
    }
    visited[0][0] = true
    sol(0, 0)
    println(arr[nums[0] - 1][nums[1] - 1])
}

fun sol(
    y: Int,
    x: Int,
)  {
    var queue = LinkedList<Array<Int>>()
    queue.add(arrayOf(y, x))

    while (!queue.isEmpty()) {
        val n = queue.poll()
        for (i in 0 until 4) {
            val nowY = n[0] + dy[i]
            val nowX = n[1] + dx[i]
            if (nowX in 0 until arr[0].size && nowY in 0 until arr.size && arr[nowY][nowX] != 0 && !visited[nowY][nowX]) {
                visited[nowY][nowX] = true
                arr[nowY][nowX] = arr[n[0]][n[1]] + 1
                queue.add(arrayOf(nowY, nowX))
            }
        }
    }
}
