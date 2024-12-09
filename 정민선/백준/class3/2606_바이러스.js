const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let line = Number(input.shift());
let nodes = Array.from({ length: N + 1 }, () => []);

for (let node of input) {
    let [node1, node2] = node.split(' ').map(Number);
    nodes[node1].push(node2);
    nodes[node2].push(node1);
}

function dfs(start) {
    let queue = [...nodes[start]];
    let count = 0;
    let visited = Array(N+1).fill(false);
    visited[start] = true;
    while (queue.length){
        let next = queue.shift(); 
        if (!visited[next]){
            visited[next] = true;
            count++;
            queue.push(...nodes[next]);
        }
    }
    return count;
}

console.log(dfs(1))