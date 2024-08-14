/*
3
21 Junkyu
21 Dohyun
20 Sunyoung*/
import java.util.*
import java.io.*
import kotlin.math.min

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var arr = Array(n){Array(2){""}}
    for(i in 0 until n){
        arr[i] = br.readLine().split(" ").toTypedArray()
    }
    arr.sortWith{a,b->
        a[0].toInt()-b[0].toInt()
    }
    for(k in arr){
        println("${k[0]} ${k[1]}")
    }
}
