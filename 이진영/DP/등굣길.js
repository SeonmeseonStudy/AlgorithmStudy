function solution(m, n, puddles) {
    // [m][n] = [m - 1][n] + [m][n - 1]
    let route = Array.from(Array(m), () => Array(n).fill(-1))
    
    puddles.forEach(val => {
        route[val[0] - 1][val[1] - 1] = 0;
    })
    route[0][0] = 1;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (route[i][j] === -1) {
                let sum = 0;
                if (i - 1 >= 0) sum += route[i - 1][j];
                if (j - 1 >= 0) sum += route[i][j - 1];
                route[i][j] = sum % 1000000007;
            }
        }
    }
    
    return route[m - 1][n - 1];
    
}