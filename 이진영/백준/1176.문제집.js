const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map(v => v.split(" ").map(Number));

const graph = Array.from({ length: n + 1 }, () => []);
const indegree = Array(n + 1).fill(0);
const visited = Array(n + 1).fill(false);

arr.forEach(([a, b]) => {
    graph[a].push(b);
    indegree[b]++;
});

class MinHeap {
    constructor() {
        this.heap = [];
    }

    swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(value) {
        this.heap.push(value);
        this.bubbleUp();
    }

    pop() {
        if (this.size() === 0) return null;
        if (this.size() === 1) return this.heap.pop();

        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return top;
    }

    bubbleUp() {
        let i = this.heap.length - 1;
        let p = Math.floor((i - 1) / 2);

        while (this.heap[p] && this.heap[i] < this.heap[p]) {
            this.swap(i, p);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    bubbleDown() {
        let i = 0;
        let l = 2 * i + 1;
        let r = 2 * i + 2;

        while (this.heap[l] && this.heap[l] < this.heap[i] || this.heap[r] && this.heap[r] < this.heap[i]) {
            let min = this.heap[r] && this.heap[r] < this.heap[l] ? r : l;
            this.swap(i, min);
            i = min;
            l = 2 * i + 1;
            r = 2 * i + 2;
        }
    }

    size() {
        return this.heap.length;
    }
}

const h = new MinHeap();

for (let i = 1; i < n + 1; i++) {
    if (indegree[i] === 0) h.push(i);
}

let answer = [];

while (h.size()) {
    const node = h.pop();
    answer.push(node);

    for (let next of graph[node]) {
        if (visited[next]) continue;
        indegree[next]--;
        if (indegree[next] === 0) h.push(next);
    }
}

console.log(answer.join(" "));