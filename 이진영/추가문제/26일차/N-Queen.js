const n = Number(require('fs').readFileSync('dev/stdin').toString().trim());

// 퀸은 좌우상하 자유롭게 움직일 수 있다 -> 줄이나 열이 겹치면 안된다.
// 대각선을 이동할 수 있다 -> 1 차이가 나면 안된다.
// 0 ~ n - 1까지 있다고 가정

let count = 0;

const func = (visited, arr) => {
    const l = arr.length;

    if (l === n) {
        count++;
        return;
    }

    for (let i = 0; i < n; i++) {
        if (visited[i] ||
            l > 0 && arr.some((value, idx) => 
                value === i || Math.abs(value - i) === l - idx
            )) {
            continue;
        }
        visited[i] = true;
        func(visited, [...arr, i]);
        visited[i] = false;
    }
}

func(Array(n).fill(false), []);

console.log(count);
