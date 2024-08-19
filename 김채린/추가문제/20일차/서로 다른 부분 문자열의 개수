import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim()
    val result = mutableSetOf<String>()
    for (i in 0 until n.length) {
        for (j in i + 1 until n.length + 1) {
            result.add(n.substring(i, j))
        }
    }
    print(result.size)
}
