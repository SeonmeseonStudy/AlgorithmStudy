const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");

function w(a, b, c, memo){
    const key = `${a}, ${b}, ${c}`
    if (memo[key] !== undefined) return memo[key]
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1;
    }
    if (a > 20 || b > 20 || c > 20) {
        return w(20, 20, 20, memo);
    }
    if (a < b && b < c) {
        memo[key] = w(a, b, c-1, memo) + w(a, b-1, c-1, memo) - w(a, b-1, c, memo);
        return memo[key];
    }
    memo[key] = w(a-1, b, c, memo) + w(a-1, b-1, c, memo) + w(a-1, b, c-1, memo) - w(a-1, b-1, c-1, memo);
    return memo[key];  
}

const memo = {};
for (let i=0; i<input.length-1; i++){
    let [a, b, c] = input[i].split(' ').map(Number);
    let result = w(a, b, c, memo);
    console.log(`w(${a}, ${b}, ${c}) = ${result}`);
}