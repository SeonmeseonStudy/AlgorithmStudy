// GPT 풀이

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const board = input.slice(1).map(line => line.split(''));

let red, blue;

// R, B 위치 찾기 + 보드에서 제거
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (board[i][j] === 'R') {
            red = [i, j];
            board[i][j] = '.';
        }
        if (board[i][j] === 'B') {
            blue = [i, j];
            board[i][j] = '.';
        }
    }
}

const dx = [-1, 1, 0, 0]; // 상하좌우
const dy = [0, 0, -1, 1];

function move(x, y, dx, dy) {
    let count = 0;
    while (board[x + dx][y + dy] !== '#' && board[x][y] !== 'O') {
        x += dx;
        y += dy;
        count++;
    }
    return [x, y, count];
}

function bfs() {
    const visited = new Set();
    const queue = [];
    queue.push([red[0], red[1], blue[0], blue[1], 0]);
    visited.add(`${red[0]},${red[1]},${blue[0]},${blue[1]}`);

    while (queue.length) {
        const [rx, ry, bx, by, depth] = queue.shift();
        if (depth >= 10) return -1;

        for (let i = 0; i < 4; i++) {
            let [nrx, nry, rc] = move(rx, ry, dx[i], dy[i]);
            let [nbx, nby, bc] = move(bx, by, dx[i], dy[i]);

            // 파란 구슬이 구멍에 빠졌으면 무효
            if (board[nbx][nby] === 'O') continue;

            // 빨간 구슬만 빠졌으면 성공
            if (board[nrx][nry] === 'O') return depth + 1;

            // 구슬 겹침 처리
            if (nrx === nbx && nry === nby) {
                if (rc > bc) {
                    nrx -= dx[i];
                    nry -= dy[i];
                } else {
                    nbx -= dx[i];
                    nby -= dy[i];
                }
            }

            const key = `${nrx},${nry},${nbx},${nby}`;
            if (!visited.has(key)) {
                visited.add(key);
                queue.push([nrx, nry, nbx, nby, depth + 1]);
            }
        }
    }

    return -1;
}

console.log(bfs());
