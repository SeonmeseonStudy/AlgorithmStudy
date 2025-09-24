const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');
const [n, m] = input[0].split(' ').map(Number);
const map = input.slice(1).map(line => line.split(''));

const visited = Array.from({ length: n }, () => Array(m).fill(0));
let answer = 0;
let num = 1;

for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (visited[i][j] === 0) {
            dfs(i, j, num);
            num++;
        }
    }
}

console.log(answer);

function dfs(x, y, num) {
    let next = [x, y];
    while (visited[next[0]] && visited[next[0]][next[1]] === 0) {
        visited[next[0]][next[1]] = num;
        switch(map[next[0]][next[1]]) {
            case "R":
                next = [next[0], next[1] + 1];
                break;
            case "L":
                next = [next[0], next[1] - 1];
                break;
            case "U":
                next = [next[0] - 1, next[1]];
                break;
            case "D":
                next = [next[0] + 1, next[1]];
                break;
        }
    }

    if (visited[next[0]] && visited[next[0]][next[1]] !== num) return;
    answer++;
}