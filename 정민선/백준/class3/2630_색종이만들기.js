const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input[0]);
let board = input.slice(1).map(e => e.split(' ').map(Number));
let white = 0, black = 0;

function isSameColor(x, y, size){
    let color = board[x][y];
    for (let i=x; i<x+size; i++){
        for (let j=y; j<y+size; j++) {
            if (board[i][j] !== color){
                return false;
            }
        }
    }
    if (color === 0) white++;
    else black++;
    
    return true;
}

function divide(x, y, size){
    if (isSameColor(x, y, size)){
        return;
    }

    let divideSize = Math.floor(size/2);
    divide(x, y, divideSize);
    divide(x, y+divideSize, divideSize);
    divide(x+divideSize, y, divideSize);
    divide(x+divideSize, y+divideSize, divideSize);
}

divide(0, 0, N);
console.log(white);
console.log(black);