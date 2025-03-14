const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const N = Number(input);

let board = Array.from({length : N}, () => Array(N*2-1).fill(' '));

function drawTriangle(n, x, y) {
    if (n === 3) { 
        board[x][y + 2] = '*';
        board[x + 1][y + 1] = '*';
        board[x + 1][y + 3] = '*';
        for (let i = 0; i < 5; i++) {
            board[x + 2][y + i] = '*';
        }
        return;
    }

    let half = n / 2;
    drawTriangle(half, x, y + half);
    drawTriangle(half, x + half, y);
    drawTriangle(half, x + half, y + n);
}

drawTriangle(N, 0, 0);
console.log(board.map(row => row.join('')).join('\n'));