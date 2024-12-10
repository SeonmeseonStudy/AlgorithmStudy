import java.io.*

var count = 0
var result = 0
var result2 = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().split(" ").map { it.toInt() }
    result = n[1]
    val arr =
        br
            .readLine()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()
    mergeSort(arr, 0, arr.size - 1)
    bw.write(result2.toString())
    bw.flush()
    bw.close()
}

fun mergeSort(
    arr: Array<Int>,
    p: Int,
    r: Int,
) {
    if (p < r) {
        val q = (p + r) / 2
        mergeSort(arr, p, q)
        mergeSort(arr, q + 1, r)
        merge(arr, p, q, r)
    }
}

fun merge(
    arr: Array<Int>,
    p: Int,
    q: Int,
    r: Int,
) {
    val tmp = Array(r - p + 1) { 0 }
    var i = p
    var j = q + 1
    var t = 0

    while (i <= q && j <= r) {
        if (arr[i] <= arr[j]) {
            tmp[t++] = arr[i++]
        } else {
            tmp[t++] = arr[j++]
        }
    }

    while (i <= q) {
        tmp[t++] = arr[i++]
    }
    while (j <= r) {
        tmp[t++] = arr[j++]
    }

    // Copy the sorted subarray back to the original array and check the k-th operation
    for (k in tmp.indices) {
        arr[p + k] = tmp[k]
        count++
        if (count == result) {
            result2 = tmp[k]
            return // Exit early to save time
        }
    }
}
