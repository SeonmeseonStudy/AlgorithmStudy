const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let numbers = input.shift().split(' ').map(Number);
let sumNumbers = Array(N+1).fill(0);
for (let i=1; i<=N; i++){
    sumNumbers[i] = sumNumbers[i-1] + numbers[i-1];
}
let result = [];
for (let data of input){
    let [i, j] = data.split(' ').map(Number)
    result.push(sumNumbers[j]-sumNumbers[i-1]);
}

console.log(result.join('\n'));