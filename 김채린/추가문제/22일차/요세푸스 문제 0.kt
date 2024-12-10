import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().split(" ").map { it.toInt() }
    val q = LinkedList<Int>()
    for (i in 1..n[0]) {
        q.add(i)
    }
    val list = Array<Int>(n[0]) { 0 }
    var i = 0
    var j = 0
    while (q.size > 1) {
        i++
        if (i % n[1] != 0) {
            q.add(q.poll())
            continue
        }
        list[j] = q.poll()
        j++
    }
    list[j] = q.poll()
    println(list.joinToString(", ", "<", ">"))
}
