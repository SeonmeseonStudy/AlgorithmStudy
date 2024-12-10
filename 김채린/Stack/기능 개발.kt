import java.util.*

fun solution(
    progresses: IntArray,
    speeds: IntArray,
): IntArray {
    var index = 0
    var result = MutableList(0) { 0 }
    var stack = Stack<Int>()
    while (index < progresses.size) {
        var count = 0
        var n = (100 - progresses[index]) / speeds[index]
        if ((100 - progresses[index]) % speeds[index] != 0)
            {
                n++
            }
        stack.push(n)
        count++
        index++
        while (index < progresses.size) {
            val num = stack.pop()
            if (progresses[index] + (speeds[index] * num) >= 100)
                {
                    count++
                    index++
                    stack.push(num)
                } else {
                break
            }
        }
        result.add(count)
    }
    return result.toIntArray()
}
