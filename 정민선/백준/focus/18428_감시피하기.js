const fs = require("fs");
let input = fs
    .readFileSync("./정민선/백준/input.txt")
    .toString()
    .trim()
    .split("\n");
const N = Number(input.shift());
let board = input.map((e) => e.split(" "));
let teachers = [];
let places = [];

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (board[i][j] === "T") {
            teachers.push([i, j]);
        } else if (board[i][j] === "X") {
            places.push([i, j]);
        }
    }
}

function inrange(x, y) {
    return 0 <= x && x < N && 0 <= y && y < N;
}

function isValid() {
    let dxs = [0, 0, 1, -1],
        dys = [1, -1, 0, 0];

    for (let [x, y] of teachers) {
        for (let d = 0; d < 4; d++) {
            let nx = x,
                ny = y;
            while (inrange(nx, ny)) {
                if (board[nx][ny] === "S") return false;
                if (board[nx][ny] === "O") break;
                nx += dxs[d];
                ny += dys[d];
            }
        }
    }
    return true;
}

function backtrack(count, start) {
    if (count === 3) {
        if (isValid()) {
            console.log("YES");
            process.exit();
        }
        return;
    }

    for (let i = start; i < places.length; i++) {
        let [x, y] = places[i];
        board[x][y] = "O";
        backtrack(count + 1, i + 1);
        board[x][y] = "X";
    }
}
backtrack(0, 0);
console.log("NO");
