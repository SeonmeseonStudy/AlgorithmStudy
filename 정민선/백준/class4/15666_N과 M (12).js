const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const numbers = input.shift().split(' ').map(Number);
numbers.sort((a, b) => a - b);

const visited = Array(N).fill(false);
const result = new Set();
function dfs(select) {
    if (select.length === M) {
        result.add(select.join(' '));
        return;
    }

    for (let i=0; i<N; i++){
        if (select.length > 0 && select[select.length - 1] > numbers[i]){
            continue;
        }
        dfs([...select, numbers[i]]);
    }
}

dfs([]);
console.log([...result].join('\n'));