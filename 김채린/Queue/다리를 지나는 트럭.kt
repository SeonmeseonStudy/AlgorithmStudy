import java.util.*

class Solution {
    fun solution(
        bridge_length: Int,
        weight: Int,
        truck_weights: IntArray,
    ): Int {
        var q = LinkedList<Int>()
        var dQ = LinkedList<Int>()
        var count = 0
        var total = 0
        for (i in 0 until truck_weights.size) {
            while(true){
            if (q.isNotEmpty() && dQ.peek() == 1) {
                dQ.poll()
                total -= q.poll()
            }
            count++
            for (i in 0 until dQ.size) {
                dQ[i]--
            }

            if (total + truck_weights[i] <= weight) {
                total += truck_weights[i]
                q.add(truck_weights[i])
                dQ.add(bridge_length)
                break
            }
            }
        }
        return bridge_length+count
    }
}
