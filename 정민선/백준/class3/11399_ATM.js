const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input[0]);
let numbers = input[1].split(' ').map(Number);
let sorted = numbers.sort((a,b) => a-b);

let time = 0;
let sum = 0;
for (let i=0; i<N; i++){
    sum += sorted[i];
    time += sum; 
}
console.log(time);