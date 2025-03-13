const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
let N = Number(input);

let total = [0];

function backtrack(num) {
    total.push(num);

    let digit = num%10;
    for (let i=digit-1; i>=0; i--) {
        backtrack(num*10 + i);
    }
    
}

for (let i=0; i<10; i++) {
    backtrack(i);
}
total.sort((a, b) => a-b);
console.log(total[N] !== undefined? total[N] : -1);