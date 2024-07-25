const MOVE = [[-2, -1], [-1, -2], [-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2]];

class Game {
    constructor(l, start, goal) {
        this.l = Number(l.trim());
        this.start = start.trim().split(" ").map(Number);
        this.goal = goal.trim().split(" ").map(Number);
    }

    findMinMove() {
        let visited = Array.from(Array(this.l), () => Array(this.l).fill(false));
        let q = [[this.start[0], this.start[1], 0]]; // [r, c, count]
        // bfs로 접근

        visited[this.start[0]][this.start[1]] = true;

        while (q.length > 0) {
            let cur = q.shift();

            if (cur[0] === this.goal[0] && cur[1] === this.goal[1]) {
                return cur[2]; // 처음 goal에 도착했을 때 횟수가 최소 이동 횟수
            }

            for (let m of MOVE) {
                let nr = cur[0] + m[0];
                let nc = cur[1] + m[1];

                if (nr >= 0 && nc >= 0 && nr < this.l && nc < this.l && !visited[nr][nc]) {
                    q.push([nr, nc, cur[2] + 1]);
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}

const f = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n");
    const n = Number(input[0].trim());
    for (let i = 0; i < n; i++) {
        let g = new Game(input[i * 3 + 1], input[i * 3 + 2], input[i * 3 + 3]);
        console.log(g.findMinMove());
    }
}

f();

