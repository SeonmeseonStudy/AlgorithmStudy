const { get } = require('http');

const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const arr = input.slice(1).map(line => line.split(' ').map(Number).slice(1));

function solution() {
    const indegree = Array(n + 1).fill(0);
    const map = Array.from({ length: n + 1 }, () => []);

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < arr[i].length - 1; j++) {
            const from = arr[i][j];
            const to = arr[i][j + 1];
            map[from].push(to);
            indegree[to]++;
        }
    }

    let q = getIndegreeZero(indegree);
    let answer = [];


    while (q.length) {
        let cur = q.shift();

        answer.push(cur);
        for (let next of map[cur]) {
            indegree[next]--;
            if (!indegree[next]) q.push(next);
        }
    }
    
    return answer.length === n ? answer.join("\n") : 0;
}
function getIndegreeZero(indegree) {
    const result = [];
    for (let i = 1; i < indegree.length; i++) {
        if (indegree[i] === 0) result.push(i);
    }
    return result;
}

console.log(solution());