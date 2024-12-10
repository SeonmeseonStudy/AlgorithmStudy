class Solution {
        fun solution(citations: IntArray): Int {
        citations.sortDescending()
        val arr =citations.sortedArrayDescending()
        for (i in arr.indices) {
            if (arr[i] <= i){
                return i
            }
        }
        return citations.size
    }
}
