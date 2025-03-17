const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [R, C, K] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split(''));

let dxs = [0, -1, 0, 1], dys = [1, 0, -1, 0];
let visited = Array.from({length : R}, () => Array(C).fill(false));
let answer = 0;

function inrange(x, y) {
    return 0 <= x && x < R && 0 <= y && y < C;
}

function dfs(x, y, len) {
    if (x === 0 && y === C-1) {
        if (len === K) answer++;
        return;
    }

    for (let d=0; d<4; d++) {
        let nx = x+dxs[d], ny = y+dys[d];
        if (inrange(nx, ny) && !visited[nx][ny] && board[nx][ny] !== 'T') {
            visited[nx][ny] = true;
            dfs(nx, ny, len + 1);
            visited[nx][ny] = false;
        }
    }
}

visited[R-1][0] = true;
dfs(R-1, 0, 1);
console.log(answer);