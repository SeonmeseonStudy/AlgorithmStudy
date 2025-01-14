const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let candy = input.shift().split(' ').map(Number);

let [a,b] = [0, 0];
let candyCount = new Map();

let answer = 0;
while (b < N) {
    candyCount.set(candy[b], (candyCount.get(candy[b]) || 0)+1);
    while (candyCount.size > 2) {
        candyCount.set(candy[a], candyCount.get(candy[a])-1);
        if (candyCount.get(candy[a]) === 0) {
            candyCount.delete(candy[a]);
        }
        a++;
    }
    
    answer = Math.max(answer, (b-a)+1);
    b++;
}

console.log(answer);