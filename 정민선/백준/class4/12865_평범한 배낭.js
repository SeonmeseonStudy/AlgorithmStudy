const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [N, K] = input.shift().split(' ').map(Number);

let weights = []
for (let data of input) {
    let [weight, value] = data.split(' ').map(Number);
    weights.push([weight, value]);
}

// weights.sort((a, b) => b[1]-a[1]); // 가치 기준으로 내림차순 [ [ 6, 13 ], [ 5, 12 ], [ 4, 8 ], [ 3, 6 ] ]

let dp = Array(K+1).fill(0);

for (let i=0; i<N; i++){
    let [weight, value] = weights[i];

    for (let j=K; j>weight-1; j--) {
        dp[j] = Math.max(dp[j], dp[j-weight]+value);
    }
}
console.log(dp[K]);