const reader = require('readline').createInterface({
    input: require('fs').createReadStream('dev/stdin'),
})

let n = null, m = null;
let start = [null, null];
let board = [];
const d = [[0, 1], [1, 0], [0, -1], [-1, 0]];

reader.on('line', line => {
    if (n) {
        const row = line.split(" ").map(v => v === "1" ? -1 : Number(v));
        board.push(row);
        
        if (row.some(v => v === 2)) {
            start[0] = board.length - 1;
            start[1] = row.indexOf(2);
        }
    }
    else {
        [n, m] = line.split(" ").map(Number);
    }
})

reader.on('close', () => {
    let q = [start];
    board[start[0]][start[1]] = 0;

    while (q.length > 0) {
        const [x, y] = q.shift();

        for (const [dx, dy] of d) {
            const [nx, ny] = [x + dx, y + dy];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] !== -1) continue;
            board[nx][ny] = board[x][y] + 1;
            q.push([nx, ny]);
        }
    }

    console.log(board.map(v => v.join(" ")).join("\n"));
})