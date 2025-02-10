const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const N = Number(input.shift());
let board = input.map(e => e.split('').map(Number));
let answer = '';

function isSameNumber(x, y, size) {
    let num = board[x][y];

    for (let i=x; i<x+size; i++) {
        for (let j=y; j<y+size; j++) {
            if (num !== board[i][j]) {
                return false
            }
        }
    }
    return true;
}

function divideSize(x, y, size) {
    if (isSameNumber(x, y, size)) {
        answer += board[x][y];
        return 
    }

    let newSize = Math.floor(size/2);
    if (newSize === 0){
        newSize++;
    }

    answer += "(";
    divideSize(x, y, newSize);
    divideSize(x, y+newSize, newSize);
    divideSize(x+newSize, y, newSize);
    divideSize(x+newSize, y+newSize, newSize);
    answer += ")";
}

divideSize(0, 0, N);
console.log(answer);