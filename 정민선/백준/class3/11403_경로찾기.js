const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');

const N = Number(input[0]);
let board = input.slice(1).map(e => e.split(' ').map(Number));

for (let k=0; k<N; k++){
    for (let i=0; i<N; i++){
        for (let j=0; j<N; j++){
            if (board[k][j] === 1 && board[i][k] === 1) {
                board[i][j] = 1;
            }
        }
    }
}

for (let b of board){
    console.log(b.join(' '));
}