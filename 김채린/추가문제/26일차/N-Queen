import java.io.*

var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n) { BooleanArray(n) { false } }
    val numArr = BooleanArray(n) { false }
    sol(n, arr, 0, numArr, 0)
    print(result)
}

fun sol(
    n: Int,
    arr: Array<BooleanArray>,
    count: Int,
    numArr: BooleanArray,
    y: Int,
) {
    if (n == count) {
        result++
        return
    }

    for (i in 0 until n) {
        if (!numArr[i] && sol2(n, arr, i, y)) {
            numArr[i] = true
            arr[y][i] = true
            sol(n, arr, count + 1, numArr, y + 1)
            numArr[i] = false
            arr[y][i] = false
        }
    }
}

fun sol2(
    n: Int,
    arr: Array<BooleanArray>,
    x: Int,
    y: Int,
): Boolean {
    var newX = x
    var newY = y - 1
    var i = 1
    while (newY >= 0) {
        if (isOk(newX - i, n) && arr[newY][newX - i]) {
            return false
        }

        if (isOk(newX + i, n) && arr[newY][newX + i]) {
            return false
        }
        i++
        newY--
    }
    return true
}

fun isOk(
    x: Int,
    n: Int,
): Boolean {
    if (x >= 0 && x < n) {
        return true
    }
    return false
}
