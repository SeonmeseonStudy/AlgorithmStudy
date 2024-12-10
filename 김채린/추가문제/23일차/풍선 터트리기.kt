import java.io.*
import java.util.*

class Balloon(
    val index: Int,
    val move: Int,
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var index = 0
    val arr =
        br.readLine().split(" ").map {
            index++
            Balloon(index, it.toInt())
        }
    val deque = ArrayDeque<Balloon>()
    for (i in arr) {
        deque.add(i)
    }
    while (deque.size > 1) {
        val num = deque.pollFirst()
        print("${num.index} ")
        if (num.move > 0) {
            for (i in 1 until num.move) {
                deque.addLast(deque.pollFirst())
            }
        } else {
            for (i in num.move until 0) {
                deque.addFirst(deque.pollLast())
            }
        }
    }
    print(deque.poll().index)
}
