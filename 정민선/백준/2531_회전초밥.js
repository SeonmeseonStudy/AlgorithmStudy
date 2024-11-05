const fs = require("fs");
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
let [n, d, k, c] = input[0].split(" ").map(Number);
let numbers = input.slice(1).map(Number);
let count = Array(d + 1).fill(0);

let category = 0;
// 딱 k개 까지의 종류 구하기
for (let i=0; i<k; i++){
    if (count[numbers[i]] === 0) category++;
    count[numbers[i]] += 1;
}

let answer = category + (count[c] === 0? 1: 0);

for (let i=1; i<n; i++){
    let first = numbers[i-1];
    let last = numbers[(i+k-1)%n];

    count[first] -= 1;
    if (count[first] === 0) category -= 1;
    if (count[last] === 0) category += 1;
    count[last] += 1;
    answer = Math.max(answer, category + (count[c] === 0? 1: 0));
}
console.log(answer);