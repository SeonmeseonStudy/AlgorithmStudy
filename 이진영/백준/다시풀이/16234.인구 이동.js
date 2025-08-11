const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const [N, L, R] = input[0].split(" ").map(Number);
const board = input.slice(1).map(v => v.trim().split(" ").map(Number));
const d = [[1, 0], [-1, 0], [0, 1], [0, -1]];

let day = 0;

while (true) {
    let visited = Array.from(Array(N), () => Array(N).fill(false));
    let move = false;

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (!visited[i][j]) {
                let q = [[i, j]]
                let union = []
                let count = 0;
                let accum = 0;

                while (q.length) {
                    let [x, y] = q.shift();
                    if (visited[x][y]) continue;

                    visited[x][y] = true;
                    union.push([x, y]);
                    count++;
                    accum += board[x][y];

                    for (const [dx, dy] of d) {
                        const [nx, ny] = [x + dx, y + dy];
                        if (
                            nx >= 0 && nx < N && ny >= 0 && ny < N &&
                            !visited[nx][ny] &&
                            Math.abs(board[x][y] - board[nx][ny]) >= L &&
                            Math.abs(board[x][y] - board[nx][ny]) <= R
                        ) {
                            q.push([nx, ny]);
                        }
                    }
                }

                if (union.length > 1) {
                    const average = Math.floor(accum / count);
                    union.forEach(([x, y]) => {
                        board[x][y] = average;
                    })
                    move = true;
                }
            }
        }
    }
    if (!move) break;
    day++;
}

console.log(day);