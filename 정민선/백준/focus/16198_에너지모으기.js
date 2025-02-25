const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);

let answer = 0;
function backtrack(weight, beads) {
    if (beads.length === 2) {
        answer = Math.max(answer, weight);
        return;
    }

    for (let i=1; i<beads.length-1; i++) {
        let current = beads[i-1] * beads[i+1];
        let array = [...beads.slice(0, i), ...beads.slice(i+1)]
        backtrack(weight + current, array)
    }
}

backtrack(0, numbers);
console.log(answer);