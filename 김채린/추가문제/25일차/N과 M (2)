import java.io.*

val s = StringBuilder()
fun nAndM2(nums:List<Int>, array: Array<Int>, num:Int, count:Int) {
    if(count==nums[1]){
        for (i in array){
        s.append(i).append(" ")
        }
        s.append("\n")
        return
    }

    for (i in num..nums[0]){
            array[count] = i
            nAndM2(nums, array, i + 1, count+1)
    }
}

fun main(){
    val br = BufferedReader(System.`in`.reader())
    val nums = br.readLine().split(" ").map { it.toInt() }
    val array = Array(nums[1]){0}
    nAndM2(nums, array, 1, 0)
    println(s.toString())
}
