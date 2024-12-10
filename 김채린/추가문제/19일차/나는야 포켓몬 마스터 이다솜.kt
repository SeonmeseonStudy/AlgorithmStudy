/*26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna*/
import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().split(" ").map{it.toInt()}
    var stringMap = mutableMapOf<String,Int>()
    var intMap = mutableMapOf<Int,String>()
    for(i in 1 .. n[0]){
        val word = br.readLine()
        stringMap.put(word,i)
        intMap.put(i,word)
    }
    for(i in 1 .. n[1]){
        val question = br.readLine()
        if('1'<=question.get(0)&&question.get(0)<='9'){
            println(intMap.get(question.toInt()))
        }else{
            println(stringMap.get(question))
        }
    }
}
