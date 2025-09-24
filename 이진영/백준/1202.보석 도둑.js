const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);
const jewels = input.slice(1, n + 1).map(line => line.split(" ").map(Number)).sort((a, b) => a[0] - b[0]);
const bags = input.slice(n + 1).map(Number).sort((a, b) => a - b);

class MaxHeap {
    constructor() {
        this.heap = [];
    }

    swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    compare(i, j) {
        return this.heap[j][1] - this.heap[i][1]; // 가치만 비교 최대 힙
    }

    push(value) {
        this.heap.push(value);
        this.bubbleUp();
    }

    bubbleUp() {
        let i = this.heap.length - 1;
        let p = Math.floor((i - 1) / 2);

        while (i > 0 && this.compare(p, i) > 0) {
            this.swap(p, i);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    pop() {
        if (this.size() === 0) return null;
        if (this.size() === 1) return this.heap.pop();

        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return top;
    }

    bubbleDown() {
        let i = 0;
        let l = 2 * i + 1;
        let r = 2 * i + 2;
        
        while (this.heap[l] && this.compare(i, l) > 0 || this.heap[r] && this.compare(i, r) > 0) {
            let next = this.heap[r] && this.compare(l, r) > 0 ? r : l;
            this.swap(i, next);
            i = next;
            l = 2 * i + 1;
            r = 2 * i + 2;
        }
    }

    size() {
        return this.heap.length;
    }
}

let answer = 0;
const maxHeap = new MaxHeap();

let jewelIndex = 0;
for (const bag of bags) {
    while (jewelIndex < n && jewels[jewelIndex][0] <= bag) {
        maxHeap.push(jewels[jewelIndex]);
        jewelIndex++;
    }
    
    if (maxHeap.size() > 0) {
        answer += maxHeap.pop()[1];
    }
    
}

console.log(answer);