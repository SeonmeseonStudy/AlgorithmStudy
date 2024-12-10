import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val n = br.readLine()
        if (n == null) {
            break
        }
        sol(n.toInt(), sb)
        sb.append("\n")
    }

    println(sb.toString())
}

fun sol(
    n: Int,
    sb: StringBuilder,
) {
    if (n == 0) {
        sb.append("-")
        return
    }
    val blank = 3.0.pow(n - 1).toInt()
    for (i in 0 until 3) {
        if (i == 1) {
            for (j in 1..blank) {
                sb.append(" ")
            }
            continue
        }
        sol(n - 1, sb)
    }
}
