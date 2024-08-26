import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    var meet = false
    for (i in 1..n) {
        val s = br.readLine().split(" ")
        if(meet&&(set.contains(s[0])||set.contains(s[1]))){
                set.add(s[0])
                set.add(s[1])
                continue
            }
        if (s.contains("ChongChong")) {
            meet = true
            set.add(s[0])
            set.add(s[1])
        }
    }
    print(set.size)
}
