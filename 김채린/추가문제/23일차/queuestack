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
    val dq = ArrayDeque<Int>()
    var nums = br.readLine().split(" ")
    for (i in nums.indices) {
        if (arr[i] == 0) {
            dq.add(nums[i].toInt())
        }
    }
    br.readLine().toInt()
    val n2 = br.readLine().split(" ").map { it.toInt() }
    for (i in n2) {
        dq.addFirst(i)
        bw.write("${dq.removeLast()} ")
    }
    bw.flush()
    bw.close()
}
