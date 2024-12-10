import java.util.*
class Solution {

fun solution(clothes: Array<Array<String>>): Int {
    val map = HashMap<String, Int>()
    for (i in clothes) {
        var n = map.get(i[1])
        if (n == null) {
            map.put(i[1], 1)
        } else {
            map.put(i[1], n + 1)
        }
    }
    var result = 1
    for (i in map.values) {
        result *= i+1
    }
    return result -1
}


}
