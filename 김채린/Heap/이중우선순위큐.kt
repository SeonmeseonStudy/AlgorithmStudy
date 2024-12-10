    import java.util.*
import kotlin.collections.*
class Solution {

fun solution(operations: Array<String>): IntArray {
    val queue = PriorityQueue<Int> { a, b -> b - a }
    val queue2 = PriorityQueue<Int> { a, b -> a - b }
    for (i in operations) {
        val command = i.trim().split(" ")
        when (command[0]) {
            "I" -> {
                queue.add(command[1].toInt())
                queue2.add(command[1].toInt())
            }
            "D" -> {
                if (queue.isNotEmpty()) {
                    if (command[1] == "1") {
                        val now = queue.poll()
                        queue2.remove(now)
                    } else {
                        val  now = queue2.poll()
                        queue.remove(now)
                    }
                }
            }
        }
    }
    var result = IntArray(2)
    if (queue.isEmpty()) {
        result[1] =0
        result[0]=0
    }else{
        result[0] = queue.poll()
        result[1] = queue2.poll()
    }
    return result
}
}
