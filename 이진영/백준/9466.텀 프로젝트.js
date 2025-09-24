const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let idx = 0;
const t = +input[idx++];
const answer = [];

for (let _ = 0; _ < t; _++) {
    const n = +input[idx++];
    const arr = input[idx++].split(' ').map(Number);

    const visited = Array(n + 1).fill(0); // 방문 표시: 0 = 미방문, 양수 = 방문한 탐색 ID
    const done = Array(n + 1).fill(false); // 팀 확정 여부
    let result = n; // 팀에 속하지 않은 사람 수

    let visitId = 1;
    for (let i = 1; i <= n; i++) {
        if (!visited[i]) {
            dfs(i, visitId++);
        }
    }

    answer.push(result);

    function dfs(node, vid) {
        let cur = node;
        while (true) {
            visited[cur] = vid;
            cur = arr[cur - 1];

            if (!visited[cur]) {
                continue;
            }

            // 사이클 발견
            if (visited[cur] === vid && !done[cur]) {
                let cycleCount = 1;
                for (let tmp = arr[cur - 1]; tmp !== cur; tmp = arr[tmp - 1]) {
                    cycleCount++;
                }
                result -= cycleCount;
            }
            break;
        }

        // 경로 마무리 처리
        for (let x = node; !done[x]; x = arr[x - 1]) {
            done[x] = true;
            if (x === cur) break;
        }
    }
}

console.log(answer.join('\n'));
