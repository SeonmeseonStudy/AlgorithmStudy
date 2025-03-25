const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);

let sumPrefix = Array(N).fill(0);
sumPrefix[0] = numbers[0];
for (let i=1; i<N; i++) {
    sumPrefix[i] = sumPrefix[i-1] + numbers[i];
}

let totalMax = 0;
for (let i=1; i< N-1; i++) {
    // 꿀통의 위치가 i, left는 0에서부터 i까지, right는 N-1부터 i까지
    let left = sumPrefix[i] - numbers[0];
    let right = sumPrefix[N-1] - numbers[N-1] - sumPrefix[i-1];
    totalMax = Math.max(totalMax, left+right);
}

for (let i = 1; i < N - 1; i++) {
    // 꿀통이 N-1, left는 0고정, right는 i
    let left = sumPrefix[N-1] - numbers[0] - numbers[i];
    let right = sumPrefix[N-1] - sumPrefix[i];
    totalMax = Math.max(totalMax, left+right);
}

for (let i = 1; i < N - 1; i++) {
    // 꿀통이 N-1, left는 i, right는 고정
    let left =  sumPrefix[i] - numbers[i];
    let right = sumPrefix[N-1] - numbers[N-1] - numbers[i];
    totalMax = Math.max(totalMax, left+right);
}

console.log(totalMax);