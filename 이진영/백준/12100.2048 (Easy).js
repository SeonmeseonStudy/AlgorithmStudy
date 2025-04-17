// GPT 풀이

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input[0]);
const board = input.slice(1).map(line => line.split(' ').map(Number));

let answer = 0;

// 보드를 깊은 복사
function copyBoard(b) {
    return b.map(row => row.slice());
}

// 한 줄을 왼쪽으로 합치는 함수
function merge(row) {
    let newRow = row.filter(v => v !== 0); // 0 제거
    for (let i = 0; i < newRow.length - 1; i++) {
        if (newRow[i] === newRow[i + 1]) {
            newRow[i] *= 2;
            newRow[i + 1] = 0;
        }
    }
    return newRow.filter(v => v !== 0).concat(Array(N).fill(0)).slice(0, N);
}

// 방향별 이동
function move(board, dir) {
    let newBoard = copyBoard(board);

    if (dir === 0) { // 위
        for (let col = 0; col < N; col++) {
            let line = [];
            for (let row = 0; row < N; row++) line.push(newBoard[row][col]);
            line = merge(line);
            for (let row = 0; row < N; row++) newBoard[row][col] = line[row];
        }
    } else if (dir === 1) { // 아래
        for (let col = 0; col < N; col++) {
            let line = [];
            for (let row = N - 1; row >= 0; row--) line.push(newBoard[row][col]);
            line = merge(line);
            for (let row = N - 1, i = 0; row >= 0; row--, i++) newBoard[row][col] = line[i];
        }
    } else if (dir === 2) { // 왼쪽
        for (let row = 0; row < N; row++) {
            newBoard[row] = merge(newBoard[row]);
        }
    } else if (dir === 3) { // 오른쪽
        for (let row = 0; row < N; row++) {
            newBoard[row] = merge(newBoard[row].slice().reverse()).reverse();
        }
    }

    return newBoard;
}

// 보드 내 최대 블록 반환
function getMax(board) {
    return Math.max(...board.flat());
}

// DFS로 5번 이동 모든 경우 탐색
function dfs(board, depth) {
    if (depth === 5) {
        answer = Math.max(answer, getMax(board));
        return;
    }

    for (let dir = 0; dir < 4; dir++) {
        const moved = move(board, dir);
        dfs(moved, depth + 1);
    }
}

dfs(board, 0);
console.log(answer);
