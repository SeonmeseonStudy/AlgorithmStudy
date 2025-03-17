const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let board = input.map(e => e.split(' ').map(Number));

function checkNumber(size, x, y) {
    let std = board[x][y];
    for (let i=x; i<x+size; i++) {
        for (let j=y; j<y+size; j++) {
            if (std !== board[i][j]) {
                return false;
            }
        }
    }
    return true;
}

function divide(size, x, y) {
    if (checkNumber(size, x, y)) {
        result[board[x][y] + 1]++;
        return;
    }

    let newSize = size/3;
    
    divide(newSize, x, y);
    divide(newSize, x+newSize, y);
    divide(newSize, x, y+newSize);
    divide(newSize, x+newSize, y+newSize);
    divide(newSize, x+newSize+newSize, y);
    divide(newSize, x, y+newSize+newSize);
    divide(newSize, x+newSize+newSize, y+newSize);
    divide(newSize, x+newSize, y+newSize+newSize);
    divide(newSize, x+newSize+newSize, y+newSize+newSize);
}

let result = Array(3).fill(0);
divide(N, 0, 0);
console.log(result.join('\n'));