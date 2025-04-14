var input = require('fs').readFileSync("dev/stdin").toString().split("\n");

var n = +input[0];
var a = input[1].split(" ").map(Number);
var b = input[2].split(" ").map(Number);

class Heap {
    constructor() {
        this.heap = [];
    }
    swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }
}

class MinHeap extends Heap {
    constructor() {
        super();
    }

    bubbleUp() {
        var i = this.heap.length - 1;
        var p = Math.floor((i - 1) / 2);

        while (this.heap[p] !== undefined && this.heap[p] > this.heap[i]) {
            this.swap(i, p);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    bubbleDown() {
        var i = 0;
        var l = 2 * i + 1;
        var r = 2 * i + 2;

        while (
            this.heap[l] !== undefined && this.heap[l] < this.heap[i] ||
            this.heap[r] !== undefined && this.heap[r] < this.heap[i]
        ) {
            let next = this.heap[r] < this.heap[l] ? r : l;

            this.swap(i, next);
            i = next;
            l = 2 * i + 1;
            r = 2 * i + 2;
        }
    }

    push(val) {
        this.heap.push(val);
        this.bubbleUp();
    }

    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();

        var val = this.heap[0];
        this.heap[0] = this.heap.pop();

        this.bubbleDown();

        return val;
    }
}

class MaxHeap extends Heap {
    constructor() {
        super();
    }

    bubbleUp() {
        var i = this.heap.length - 1;
        var p = Math.floor((i - 1) / 2);

        while (this.heap[p] !== undefined && this.heap[p] < this.heap[i]) {
            this.swap(i, p);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }

    bubbleDown() {
        var i = 0;
        var l = 2 * i + 1;
        var r = 2 * i + 2;

        while (
            this.heap[l] !== undefined && this.heap[l] > this.heap[i] ||
            this.heap[r] !== undefined && this.heap[r] > this.heap[i]
        ) {
            let next = this.heap[r] > this.heap[l] ? r : l;

            this.swap(i, next);
            i = next;
            l = 2 * i + 1;
            r = 2 * i + 2;
        }
    }

    push(val) {
        this.heap.push(val);
        this.bubbleUp();
    }

    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();

        var val = this.heap[0];
        this.heap[0] = this.heap.pop();

        this.bubbleDown();

        return val;
    }
}

var aMinHeap = new MinHeap();
var bMaxHeap = new MaxHeap();

for (let i = 0; i < n; i++) {
    aMinHeap.push(a[i]);
    bMaxHeap.push(b[i]);
}

var result = 0;

for (let i = 0; i < n; i++) {
    result += aMinHeap.pop() * bMaxHeap.pop();
}

console.log(result);

