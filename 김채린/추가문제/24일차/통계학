/*첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.

예제 입력 1
5
1
3
8
-2
2*/
import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n) { 0 }
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    var total = 0
    var map = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
        map[arr[i]] = if (map[arr[i]] == null) 1 else map[arr[i]]!!.plus(1)
        total += arr[i]
        max = max(max, arr[i])
        min = min(min, arr[i])
    }
    arr.sort()
    var switch = false
    var set = arr.toSet()
    var maxCount = mutableListOf(0, 0)
    for (i in set) {
        if (maxCount[1] < map[i]!!) {
            maxCount[0] = i
            maxCount[1] = map[i]!!
            switch = false
        } else if (maxCount[1] == map[i]!! && !switch) {
            maxCount[0] = i
            switch = true
        }
    }
    println(round(total.toDouble() / n.toDouble()).toInt())
    println(arr[n / 2])
    println(maxCount[0])
    println(max - min)
}
