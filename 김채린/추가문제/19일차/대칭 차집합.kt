import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine().split(" ").map { it.toInt() }
    var map = mutableMapOf<Int, Int>()
    var n = br.readLine().split(" ").map { it.toInt() }
    for (i in n) {
        map[i] = 1
    }
    n = br.readLine().split(" ").map { it.toInt() }
    for (i in n) {
        if (map.containsKey(i)) {
            map[i] = 0
        } else {
            map[i] = 1
        }
    }
    var count = 0
    for (i in map) {
        count += i.value
    }
    println(count)
}
