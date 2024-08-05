import kotlin.math.*

class Solution {
    var result = 0

fun solution(name: String): Int {
    var arr = name.toCharArray()
    var length = arr.size
    var move = name.length - 1
    for (i in arr.indices) {
        if (isFront(arr[i])) {
            result += arr[i] - 'A'
        } else {
            result++
            result += abs(arr[i] - 'Z')
        }
        var index = i + 1
        while (index < arr.size && arr[index] == 'A') {
            index++
        }
        move = min(move, i * 2 + length - index)
        move = min(move, (length - index) * 2 + i)
    }
    result += move
    return result
}

fun isFront(char: Char): Boolean {
    if (char - 'A' < 13) {
        return true
    } else {
        return false
    }
}
}
