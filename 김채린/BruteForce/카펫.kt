class Solution {
    fun solution(
        brown: Int,
        yellow: Int,
    ): IntArray {
        var h = 0
        val result: IntArray
        while (true) {
            h++
            if (yellow % h!=0){continue}
            val nowW = yellow / h
            val nowBrown = (nowW + 2) * 2 + h * 2
            if (nowBrown == brown) {
                result = intArrayOf(nowW + 2, h + 2)
                break
            }
        }
        return result
    }
}
