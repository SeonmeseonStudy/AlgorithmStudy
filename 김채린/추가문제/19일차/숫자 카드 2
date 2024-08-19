/*10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10*/
import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    br.readLine().toInt()
    var map = mutableMapOf<Int,Int>()
    val num = br.readLine().split(" ").map{it.toInt()}
    for(i in num){
        map.put(i,(map.get(i)?:0)+1)
    }
    br.readLine().toInt()
    val resultArr = br.readLine().split(" ").map{it.toInt()}
    for(i in resultArr){
        bw.write("${map.get(i)?:0} ")
    }
    bw.flush()
    bw.close()
}
