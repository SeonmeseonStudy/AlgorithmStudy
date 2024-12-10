class Solution {
fun solution(
    n: Int,
    results: Array<IntArray>,
): Int {
    var resultArr = Array(n + 1) { IntArray(n + 1){2} }
    for (result in results) {
        resultArr[result[0]][result[1]] = 1
        resultArr[result[1]][result[0]] = -1
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (resultArr[i][j] == 2) {
                    if (i==j){
                        resultArr[i][j] = 0
                        continue
                    }
                    if (resultArr[i][k] == 1 && resultArr[k][j] == 1) {
                        resultArr[i][j] = 1
                    }
                    if (resultArr[i][k] == -1 && resultArr[k][j] == -1) {
                        resultArr[i][j] = -1
                    }
                }
            }
        }
    }
    var result = n
    for (i in 1..n) {
        for (j in 1..n) {
            if (resultArr[i][j] == 2) {
                result--
                break
            }
        }
    }
    return result
}

}
