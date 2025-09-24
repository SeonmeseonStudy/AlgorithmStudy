class Heap {
    constructor() {
        this.heap = [];
    }

    length() {
        return this.heap.length;
    }

    swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(val) {
        this.heap.push(val);

        let i = this.heap.length - 1;
        let p = Math.floor((i - 1) / 2);

        while (this.heap[p] && this.heap[p][1] > this.heap[i][1]) {
            this.swap(i, p);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();

        let ret = this.heap[0];

        this.heap[0] = this.heap.pop();

        let i = 0;
        let l = 2 * i + 1;
        let r = 2 * i + 2;

        while (
            this.heap[l] && this.heap[l][1] < this.heap[i][1] ||
            this.heap[r] && this.heap[r][1] < this.heap[i][1]
        ) {
            const min = this.heap[r] && this.heap[r][1] < this.heap[l][1] ? r : l
            this.swap(i, min);

            i = min;
            l = 2 * i + 1;
            r = 2 * i + 2;
        }

        return ret;
    }
}

const reader = require('readline').Interface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
})

let N, M;
let map = new Map();
let answer = Infinity;

reader.on('line', line => {
    if (!N) {
        [N, M] = line.trim().split(" ").map(Number);
        for (let i = 0; i < N; i++) map.set(i, []);
    } else {
        [a, b, c] = line.trim().split(" ").map(Number);

        map.get(a - 1).push([b - 1, c]);
        map.get(b - 1).push([a - 1, c]);
    }
})

reader.on('close', () => {
    let dist = Array(N).fill(Infinity)
    dist[0] = 0;

    let q = new Heap();

    q.push([0, 0]);

    while (q.length()) {
        const [cur, accum] = q.pop();

        if (dist[cur] < accum) continue;

        for (const [next, cost] of map.get(cur)) {
            if (accum + cost < dist[next]) {
                dist[next] = accum + cost;
                q.push([next, accum + cost]);
            }
        }
    }

    console.log(dist[N - 1]);
})