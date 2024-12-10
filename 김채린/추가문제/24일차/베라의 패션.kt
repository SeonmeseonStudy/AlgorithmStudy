import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if(n<2){
        print(0)
    }else{
        print(n*(n-1))
    }
}
