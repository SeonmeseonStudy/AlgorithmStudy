import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n[0]) {
        val s = br.readLine()
        if (s.length >= n[1]) {
            map[s] = map.getOrDefault(s, 0) + 1
        }
    }
    val sort =
        map.entries.sortedWith { a, b ->
            when {
                a.value == b.value ->
                    when {
                        a.key.length == b.key.length -> a.key.compareTo(b.key)
                        else -> b.key.length - a.key.length
                    }
                else -> {
                    b.value - a.value
                }
            }
        }
    for (i in sort) {
        bw.write("${i.key}\n")
    }
    bw.flush()
    bw.close()
}
