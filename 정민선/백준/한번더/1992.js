const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const N = Number(input.shift());
let board = input.map(e => e.split('').map(Number));

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

let string = "";
function divide(x, y, size) {
    if (isSameNumber(x, y, size)) {
        string += board[x][y];
        return;
    }

    string += "(";
    let newSize = size/2;

    divide(x, y, newSize);
    divide(x, y+newSize, newSize);
    divide(x+newSize, y, newSize);
    divide(x+newSize, y+newSize, newSize);
    string += ")";
}
divide(0, 0, N);
console.log(string);