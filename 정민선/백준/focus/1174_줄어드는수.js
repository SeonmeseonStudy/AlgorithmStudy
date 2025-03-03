const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
let N = Number(input);

let numbers = [];

function backtrack(num) {
    numbers.push(num);

    let digit = num%10;
    
    for (let i=digit-1; i>=0; i--) {
        backtrack(num*10 + i);
    }
}
for (let i=0; i<10; i++) {
    backtrack(i);
}

numbers.sort((a, b) => a-b);
console.log(numbers[N-1] !== undefined? numbers[N-1]: -1);