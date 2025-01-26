const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
let table = input.slice(0, N).map(e => e.split(' ').map(Number))
let prefix = Array.from({length: N+1}, () => Array(N+1).fill(0));

for (let i=1; i<N+1; i++){
    for (let j=1; j<N+1; j++){
        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + table[i-1][j-1] - prefix[i-1][j-1];
    }
}

for (let i=N; i<N+M; i++){
    let [x1, y1, x2, y2] = input[i].split(' ').map(Number);
    console.log(prefix[x2][y2] + prefix[x1-1][y1-1] - prefix[x1-1][y2] - prefix[x2][y1-1]);
}