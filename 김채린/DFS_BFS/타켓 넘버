class Solution {
    var count =0
fun solution(
    numbers: IntArray,
    target: Int,
): Int {
    search(numbers, target,0,0)
    return count
}

fun search(numbers: IntArray,target: Int, index:Int, total:Int) {
    if (index==numbers.size){
        if (total==target){
            count++
        }
        return
    }
        search(numbers, target, index+1, total+numbers[index])
        search(numbers, target, index+1, total-numbers[index])

}
}
