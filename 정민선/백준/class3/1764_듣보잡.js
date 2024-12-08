const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let listen = new Set(input.slice(0, N));
let result = [];

for (let i=N; i<N+M; i++){
    if (listen.has(input[i])){
        result.push(input[i]);
    }
}
result.sort((a, b) => a.localeCompare(b));
console.log(result.length);
console.log(result.join('\n'));