const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const [R, C, K] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split(''));

let visited = Array.from({length : R}, () => Array(C).fill(false));
let dxs = [1, -1, 0, 0];
let dys = [0, 0, 1, -1];

let answer = 0;

function dfs(x, y, count) {
    if (x === 0 && y === C-1) {
        if (count === K) answer++;
        return
    }
    for (let d=0; d<4; d++) {
        let nx = x+dxs[d], ny = y+dys[d];
        if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && board[nx][ny] === '.') {
            visited[nx][ny] = true;
            dfs(nx, ny, count+1);
            visited[nx][ny] = false;
        }
    }
}

visited[R - 1][0] = true;
dfs(R-1, 0, 1);
console.log(answer);