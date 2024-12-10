import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().split(" ").map{it.toInt()}
    var m = br.readLine().split(" ").map{it.toInt()}
    var totalA = n[0]*m[1]+m[0]*n[1]
    var totalB =n[1]*m[1]
    sol(totalA,totalB).also{if(it!=0){
        totalA/=it
        totalB/=it
    }}
    print("${totalA} ${totalB}")
}

fun sol(a:Int, b:Int):Int{
    if(a%b==0){
        return b
    }
    return sol(b,a%b)
}
