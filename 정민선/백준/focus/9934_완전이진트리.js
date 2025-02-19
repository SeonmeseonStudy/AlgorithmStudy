const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);

let graph = Array.from({length : N}, () => []);

class Node {
    constructor(node) {
        this.node = node;
        this.left = null;
        this.right = null;
    }
}

let tree = function (nodes, depth) {
    if (nodes.length === 0) return;

    let mid = Math.floor(nodes.length / 2);
    graph[depth].push(nodes[mid]);

    tree(nodes.slice(0, mid), depth+1);
    tree(nodes.slice(mid+1), depth+1);
}

tree(numbers, 0);
console.log(graph.map(e => e.join(' ')).join('\n'))