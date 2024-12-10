const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
let [n, k] = input[0].split(" ").map(Number);
let numbers = input[1].split(" ").map(Number);
let count = Array(100001).fill(0);
let start = 0;
let answer = 0;

for (let i=0; i<n; i++){
    count[numbers[i]] += 1;

    while (count[numbers[i]] > k) {
        count[numbers[start]] -= 1;
        start += 1;
    }
    answer = Math.max(answer, i-start+1);
}
console.log(answer);