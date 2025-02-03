const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());

let lengths = [3];
let k = 0;

while (lengths[k] < N) {
    lengths.push(lengths[k] * 2 + (k + 4));
    k++;
}

function findMoo(n, k){
    if (k === 0) return "moo"[n-1];
    let pre = lengths[k-1];
    let mid = k+3;

    if (n <= pre){
        return findMoo(n, k-1);
    } else if (n <= pre+mid){
        return (n-pre === 1) ? 'm' : 'o';
    } else {
        return findMoo(n-pre-mid, k-1);
    }
}

console.log(findMoo(N, k))