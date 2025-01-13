const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim();
const N = Number(input);
let count = 0;

let board = Array.from({length : N}, () => Array(N).fill(0));
function isSafe(row, col){
    for(let i=0; i<row; i++){
        if (board[i][col] === 1) return false;
        if ((col-(row-i)>=0) && board[i][col-(row-i)] === 1) return false;
        if ((col+(row-i)<N) && board[i][col+(row-i)] === 1) return false;
    }
    return true;
}

function backtrack(row) {
    if (row === N) {
        return count++;
    }

    for (let col=0; col<N; col++){
        if (isSafe(row, col)){
            board[row][col] = 1;
            backtrack(row+1);
            board[row][col] = 0;
        }
    }
}

backtrack(0);
console.log(count);