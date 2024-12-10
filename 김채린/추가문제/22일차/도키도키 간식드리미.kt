import java.util.*
import java.io.*

fun main(){
    val s1 = Stack<Int>()
    val s2 = Stack<Int>()
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    br.readLine().split(" ").reversed().forEach{s1.push(it.toInt())}
    var i =1
    var result = true
    while(s1.isNotEmpty()||s2.isNotEmpty()){
        var a = -1
        var b = -1
        if(s1.isNotEmpty()){
            a = s1.pop()
        }
        if(s2.isNotEmpty()){
            b =s2.pop()
        }
        if(a==i){
            i++
            if(b!=-1){
            s2.push(b)
            }
        }else if(b==i){
            i++
            if(a!=-1){
            s1.push(a)
            }
        }else if(a==-1){
            result = false
            break
        }else{
            if(b!=-1){
            s2.push(b)
            }
            s2.push(a)
        }
    }
    if(result){
        print("Nice")
    }else{
        print("Sad")
    }
}
