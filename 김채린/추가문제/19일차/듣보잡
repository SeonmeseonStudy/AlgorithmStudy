import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    var map = mutableMapOf<String, Int>()
    for (i in 0 until nums[0]) {
        val w = br.readLine()
        map[w] = map.getOrDefault(w, 0) + 1
    }
    var result = mutableListOf<String>()
    for (i in 0 until nums[1]) {
        val w = br.readLine()
        if (map[w] != null) {
            result.add(w)
        }
    }
    result.sort()
    println(result.size)
    for (i in result) {
        println(i)
    }
}
