const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);

let numbers  = Array.from({length: N}, (e, index) => index+1);
let visited = Array(N).fill(false);

function dfs(values){
    if (values.length === M) {
        console.log(values.join(' '));
        return;
    }

    for (let i=0; i<N; i++){
    if (!visited[i]){
        if (values.length > 0 && values[values.length-1] > numbers[i]){
            continue;
        }
        visited[i] = true;
        dfs([...values, numbers[i]]);
        visited[i] = false;
    }
    }
}

dfs([])