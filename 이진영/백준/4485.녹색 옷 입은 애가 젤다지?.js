class Heap {
    constructor() {
        this.heap = [];
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(val) {
        this.heap.push(val);

        let i = this.heap.length - 1;
        let p = Math.floor((i - 1) / 2);

        while (
            this.heap[p] && this.heap[p][2] > this.heap[i][2]
        ) {
            this.swap(p, i);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();

        const result = this.heap[0];

        this.heap[0] = this.heap.pop();

        let i = 0;
        let l = i * 2 + 1;
        let r = i * 2 + 2;

        while (
            this.heap[l] && this.heap[l][2] < this.heap[i][2] ||
            this.heap[r] && this.heap[r][2] < this.heap[i][2]
        ) {
            const min = this.heap[r] && this.heap[r][2] < this.heap[l][2] ? r : l;

            this.swap(i, min);

            i = min;
            l = i * 2 + 1;
            r = i * 2 + 2;
        }

        return result;
    }
}

const reader = require('readline').Interface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
})

let n = 0;
let board = [];
let answer = [];
const d = [[0, 1], [0, -1], [-1, 0], [1, 0]]
reader.on('line', line => {
    if (!n) {
        n = +line.trim();
        board = [];
        if (n === 0) reader.close();
    } else {
        board.push(line.trim().split(" ").map(Number));
        n--;

        if (n === 0) {
            answer.push(getMin())
        }
    }
})

reader.on('close', () => {
    console.log(answer.map((v, i) => `Problem ${i + 1}: ${v}`).join("\n"))
})

function getMin() {
    const l = board.length
    const h = new Heap();
    const dp = Array.from(Array(l), () => Array(l).fill(Infinity));
    dp[0][0] = board[0][0];
    h.push([0, 0, dp[0][0]]);

    while (!h.isEmpty()) {
        const [x, y, c] = h.pop();

        for (const [dx, dy] of d) {
            const [nx, ny] = [x + dx, y + dy];

            if (
                nx >= 0 && nx < l && ny >= 0 && ny < l &&
                dp[nx][ny] > c + board[nx][ny]
            ) {
                dp[nx][ny] = c + board[nx][ny]
                h.push([nx, ny, dp[nx][ny]])
            }
        }
    }
    
    return dp[l - 1][l - 1];
}