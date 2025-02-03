const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let board = input.map(e => e.split(' ').map(Number));
let result = Array(3).fill(0);
function isSameNumber(row, col, size){
    let std = board[row][col];
    for (let i=row; i<row+size; i++){
        for (let j=col; j<col+size; j++){
            if (std !== board[i][j]){
                return false
            }
        }
    }
    result[std+1]++;
    return true
}

function divideSize(row, col, size){
    if (isSameNumber(row, col, size)){
        return
    }

    let newSize = Math.floor(size/3);
    if (newSize === 0){
        newSize++;
    }
    divideSize(row, col, newSize);
    divideSize(row, col+newSize, newSize);
    divideSize(row+newSize, col, newSize);
    divideSize(row+newSize, col+newSize, newSize);
    divideSize(row+newSize+newSize, col, newSize);
    divideSize(row, col+newSize+newSize, newSize);
    divideSize(row+newSize+newSize, col+newSize, newSize);
    divideSize(row+newSize, col+newSize+newSize, newSize);
    divideSize(row+newSize+newSize, col+newSize+newSize, newSize);
}

divideSize(0,0,N);
console.log(result.join('\n'));