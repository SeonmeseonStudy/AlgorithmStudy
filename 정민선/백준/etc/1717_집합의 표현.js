const fs = require('fs');
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let node = Array.from({length : N+1}, (value, i) => i);

function find(x) {
    if (node[x] === x) return x;
    return node[x] = find(node[x]);
}

function union(a, b) {
    let rootA = find(a);
    let rootB = find(b);
    if (rootA !== rootB) node[rootB] = rootA;
}

let result = [];
for (let data of input) {
    let [num, a, b] = data.split(" ").map(Number);
    if (num === 0) {
        union(a, b);
    } else {
        result.push(find(a) === find(b)? "YES" : "NO");
    }
}

console.log(result.join('\n'));