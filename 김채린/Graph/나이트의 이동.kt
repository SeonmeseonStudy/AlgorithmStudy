import java.io.*
import java.util.*

val dx = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)
val dy = arrayOf(2, 1, -1, -2, -2, -1, 1, 2)
var arr = Array(0) { IntArray(0) }
var end = IntArray(2)
var visited = Array(0) { Array(0) { false } }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    for (i in 0 until num) {
        val l = br.readLine().toInt()
        arr = Array(l) { IntArray(l) }
        visited = Array(l) { Array(l) { false } }
        val start =
            br
                .readLine()
                .trim()
                .split(" ")
                .map { it.toInt() }
        end =
            br
                .readLine()
                .trim()
                .split(" ")
                .map { it.toInt() }
                .toIntArray()
        if (start[0] == end[0] && start[1] == end[1]) {
            println(0)
        } else {
            println(sol(start[0], start[1]))
        }
    }
}

fun sol(
    y: Int,
    x: Int,
): Int {
    val queue = LinkedList<Array<Int>>()
    queue.add(arrayOf(y, x))
    visited[y][x] = true
    while (queue.isNotEmpty()) {
        val n = queue.poll()
        for (i in 0 until 8) {
            val nowY = n[0] + dy[i]
            val nowX = n[1] + dx[i]
            if (nowX in 0 until arr[0].size && nowY in 0 until arr.size && !visited[nowY][nowX]) {
                visited[nowY][nowX] = true
                arr[nowY][nowX] = arr[n[0]][n[1]] + 1
                queue.add(arrayOf(nowY, nowX))
                if (nowY == end[0] && nowX == end[1]) {
                    return arr[end[0]][end[1]]
                }
            }
        }
    }
    return -1
}
