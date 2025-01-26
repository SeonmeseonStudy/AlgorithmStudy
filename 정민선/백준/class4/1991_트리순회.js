const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let graph = {};

for (let i=0; i<N; i++) {
    let [node, left, right] = input.shift().split(' ');
    graph[node] = { left: left === '.' ? null : left, right: right === '.' ? null : right };
}

let pre = [];
function preorder(node){
    if (!node) return;
    pre.push(node);
    preorder(graph[node].left);
    preorder(graph[node].right);
}

preorder('A');
console.log(pre.join(''));

let ino = [];
function inorder(node){
    if (!node) return;
    inorder(graph[node].left);
    ino.push(node);
    inorder(graph[node].right);
}
inorder('A');
console.log(ino.join(''));

let post = [];
function postorder(node){
    if (!node) return;
    postorder(graph[node].left);
    postorder(graph[node].right);
    post.push(node);
}

postorder('A');
console.log(post.join(''));