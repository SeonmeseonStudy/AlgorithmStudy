import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    var count = 1
    var result = 666
    while (count < num) {
        result++
        if (result.toString().contains("666")) {
            count++
        }
    }
    println(result)
}
