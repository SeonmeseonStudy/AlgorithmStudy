const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let graph = Array(N+1).fill(0).map(e => []);

for (let cases of input) {
    let [u, v] = cases.split(' ').map(Number);
    graph[u].push(v);
    graph[v].push(u);
}

let visited = Array(N+1).fill(false);
function checkgraph(n){
    let queue = [n];
    visited[n] = true;
    
    while(queue.length) {
        let next = queue.shift();

        for (let node of graph[next]){
            if (!visited[node]){
                visited[node] = true;
                queue.push(node);
            }
        }
    }
}

let count = 0;
for (let i=1; i<=N; i++){
    if (!visited[i]){
        count++;
        checkgraph(i);
    }
}
console.log(count);