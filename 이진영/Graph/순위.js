function solution(n, results) {
    let graph = Array.from(Array(n), () => Array(n).fill(0));
    results.forEach(val => {
        graph[val[0] - 1][val[1] - 1] = 1;
        graph[val[1] - 1][val[0] - 1] = -1;
    })
    
    for (let k = 0; k < n; k++) {
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (i === j) {
                    graph[i][j] = 0;
                    continue;
                }
                if (graph[i][k] > 0 && graph[k][j] > 0) graph[i][j] = 1;
                else if (graph[i][k] < 0 && graph[k][j] < 0) graph[i][j] = -1;
            }
        }
    }
    
    return n - graph.filter(i => i.filter(i => i === 0).length > 1).length
}