const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const [N, R, Q] = input.shift().split(' ').map(Number);

let graph = Array.from({length : N+1}, () => []);
let subtrees = Array(N+1).fill(0);

for (let i=0; i<N-1; i++) {
    let [u, v] = input[i].split(' ').map(Number);
    graph[u].push(v);
    graph[v].push(u);
}

function dfs(node, parent) {
    subtrees[node] = 1;
    for (let child of graph[node]) {
        if (child !== parent) {
            subtrees[node] += dfs(child, node);
        }
    }
    return subtrees[node];
}

dfs(R, -1);
for (let i=N-1; i<N+Q-1; i++) {
    let u = Number(input[i]);
    console.log(subtrees[u])
}
