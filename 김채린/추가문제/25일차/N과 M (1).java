import java.io.BufferedReader

var count = 0;
fun nAndM(nums: List<Int>, array: Array<Int>, visited: Array<Boolean>) {
    if(count==nums[1]){
        for (i in array){
            print("$i ")
        }
        println()
        count--
        return
    }

    for (i in 1 .. nums[0]){
        if(!visited[i]) {
            array[count++] = i
            visited[i] = true
            nAndM(nums, array, visited)
            visited[i] = false
        }
    }
    count--
}

fun main(){
    val br = BufferedReader(System.`in`.reader())
    val nums =br.readLine().split(" ").map { it.toInt() }
    var array = Array(nums[1]){0}
    var visited = Array(nums[0]+1){false}
    nAndM(nums,array, visited)
}
