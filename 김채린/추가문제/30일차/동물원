import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(n + 1)
    arr[0] = 1
    arr[1] = 3
    for (i in 2..n) {
        arr[i] = (arr[i - 1] * 2 + arr[i - 2]) % 9901
    }
    System.out.println(arr[n])
}
