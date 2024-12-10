import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    br.readLine().toInt()
    val arr =
        br
            .readLine()
            .split(" ")
            .map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    val sort = arr.distinct().sorted()
    for (i in sort.indices) {
        map[sort[i]] = i
    }
    for (i in arr) {
        bw.write("${map[i]} ")
    }

    bw.flush()
    bw.close()
}
