const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);

let p1 = 0, p2 = numbers.length-1;
let x = 0, y = 0;
let answer = Infinity;

while(p1 < p2) {
    let value = numbers[p2]+numbers[p1];
    if (Math.abs(value) < Math.abs(answer) || (Math.abs(value) === Math.abs(answer) && value < answer)) {
        answer = value;
        x = numbers[p1];
        y = numbers[p2];
    }

    if (value > 0) {
        p2--;
    } else {
        p1++;
    }
}
console.log(x, y)