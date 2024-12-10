import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    var result = 0
    for (i in 1..n) {
        val s = br.readLine()
        if (s.equals("ENTER")) {
            result += set.size
            set.clear()
            continue
        }
        set.add(s)
    }
    result += set.size
    print(result)
}
