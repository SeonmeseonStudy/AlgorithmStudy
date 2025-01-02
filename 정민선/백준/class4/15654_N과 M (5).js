const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const numbers = input.shift().split(' ').map(Number);
numbers.sort((a, b) => a - b);

const visited = Array(N).fill(false);
const result = [];
function dfs(select) {
    if (select.length === M) {
        console.log(select.join(' '));
        return;
    }

    for (let i=0; i<N; i++){
        if (!visited[i]) {
            visited[i] = true;
            dfs([...select, numbers[i]]);
            visited[i] = false;
        }
    }
}

dfs([]);