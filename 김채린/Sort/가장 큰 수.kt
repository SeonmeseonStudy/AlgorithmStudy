class Solution {
    fun solution(numbers: IntArray): String {
    var answer = numbers.map { it.toString() }.sortedWith { a, b -> (b + a).compareTo(a + b) }
    var result = ""
    for (i in answer) {
        result += i
    }

    return if (answer[0] == "0") "0" else result
}
}
