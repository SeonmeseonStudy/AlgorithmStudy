const diff = [[-1, 0], [0, 1], [1, 0], [0, -1]];

const main = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n");
    const [n, m] = input[0].trim().split(" ").map(Number);
    const grid = input.slice(1).map(i => i.trim().split("").map(Number));

    let visited = Array.from(Array(n), () => Array(m).fill(false));
    let q = [[0, 0, 1]];
    visited[0][0] = true;

    let min = n * m;

    while (q.length > 0) {
        let cur = q.shift();

        if (cur[0] === n - 1 && cur[1] === m - 1) {
            min = cur[2];
            break;
        }

        for (let d of diff) {
            let nr = cur[0] + d[0];
            let nc = cur[1] + d[1];

            if (nr > -1 && nc > -1 && nr < n && nc < m && grid[nr][nc] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                q.push([nr, nc, cur[2] + 1]);
            }
        }

    }

    console.log(min);
}

main();

