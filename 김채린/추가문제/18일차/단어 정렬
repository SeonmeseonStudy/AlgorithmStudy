import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = mutableSetOf<String>()
    for(i in 0 until n){
        arr.add(br.readLine())
    }
    var sorted = arr.sortedWith{a,b-> if(a.length==b.length){
        var i=0
        val aArr=a.toCharArray()
        val bArr=b.toCharArray()
        while(i<a.length-1){
            if(a[i]==b[i]){
                i++
                continue
            }
            break
        }
        a[i]-b[i]
    }else{
        a.length-b.length
    }
                }
    for(i in sorted){
        println(i)
    }
}
