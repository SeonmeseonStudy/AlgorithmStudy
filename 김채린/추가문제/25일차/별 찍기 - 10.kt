import java.io.*

//chatgpt 사용

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val arr = Array(n) { CharArray(n) { ' ' } }

    sol(n, 0, 0, arr)

    for (line in arr) {
        sb.append(line).append("\n")
    }
    print(sb.toString())
}

fun sol(
    size: Int,
    x: Int,
    y: Int,
    arr: Array<CharArray>,
) {
    if (size == 1) {
        arr[x][y] = '*'
        return
    }

    val nextSize = size / 3
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == 1 && j == 1) {
                continue
            }
            sol(nextSize, x + i * nextSize, y + j * nextSize, arr)
        }
    }
}
