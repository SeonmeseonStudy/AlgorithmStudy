import java.io.*
import java.util.*
import kotlin.math.*

var visited = BooleanArray(0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(nums[0] + 1) { LinkedList<Int>() }
    for (i in 0 until nums[1]) {
        val n = br.readLine().split(" ").map { it.toInt() }
        arr[n[0]].add(n[1])
        arr[n[1]].add(n[0])
    }
    for (i in arr) {
        i.sort()
    }
    visited = BooleanArray(nums[0] + 1) { false }
    visited[nums[2]] = true
    dfs(nums[2], arr)
    println()
    visited[nums[2]] = false
    bfs(nums[2], arr)
}

fun dfs(
    n: Int,
    arr: Array<LinkedList<Int>>,
) {
    print("$n ")
    for (i in arr[n]) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i, arr)
        }
    }
}

fun bfs(
    n: Int,
    arr: Array<LinkedList<Int>>,
) {
    val queue = LinkedList<Int>()
    queue.add(n)
    while (queue.isNotEmpty()) {
        val now = queue.poll()
        print("$now ")
        for (i in arr[now]) {
            if (visited[i]) {
                visited[i] = false
                queue.add(i)
            }
        }
    }
}
