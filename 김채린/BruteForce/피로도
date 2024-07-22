class Solution {
    var maxCount = -1

fun solution(
    k: Int,
    dungeons: Array<IntArray>,
): Int {
    var total = 0
    var visited = Array<Boolean>(dungeons.size) { false }
    back(visited, 0, k, dungeons)
    return maxCount
}

fun back(
    visited: Array<Boolean>,
    count: Int,
    now: Int,
    dungeons: Array<IntArray>,
) {
    if (now < 1) {
        maxCount = Math.max(count, maxCount)
        return
    }
    for (i in 0 until visited.size) {
        if (!visited[i] && now >= dungeons[i][0]) {
            visited[i] = true
            back(visited, count + 1, now - dungeons[i][1], dungeons)
            visited[i] = false
        }
    }
    maxCount = Math.max(count, maxCount)
}
}
