import java.util.*
import kotlin.collections.*

fun solution(
    priorities: IntArray,
    location: Int,
): Int {
    var queue =
        LinkedList<Pair<Int, Int>>()
    for (i in priorities.indices) {
        queue.add(Pair(i, priorities[i]))
    }
    var result = 0
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (queue.any { it.second > current.second })//큐에 더 큰게 있는지 확인
            {
                queue.add(current)
            } else {
            result++
            if (current.first == location)
                {
                    break
                }
        }
    }
    return result
}
