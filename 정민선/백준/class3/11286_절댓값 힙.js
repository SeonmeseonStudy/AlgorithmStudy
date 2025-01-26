const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let T = Number(input.shift());

class AbsHeap {
    constructor() {
        this.heap = [];
    }

    insert(x) {
        this.heap.push(x);
        this.bubbleUp();
    }

    extract() {
        if (this.heap.length === 0) return 0;
        if (this.heap.length === 1) return this.heap.pop();
        const root = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return root;
    }

    compare(a, b) {
        const absA = Math.abs(a);
        const absB = Math.abs(b);
        if (absA !== absB) return absA-absB;
        return a - b; 
    }

    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            let parent = Math.floor((index-1) / 2);
            if (this.compare(this.heap[parent], this.heap[index]) <=0)
                break;
            [this.heap[parent], this.heap[index]] = [this.heap[index], this.heap[parent]];
            index = parent;
        }
    }
    
    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        const element = this.heap[0];

        while (true) {
            let left = 2*index+1;
            let right = 2*index+2;
            let swap = null;

            if (left < length) {
                if (this.compare(this.heap[left], element) < 0) {
                    swap = left;
                }
            }

            if (right < length) {
                if (this.compare(this.heap[right], swap === null? element : this.heap[left]) < 0) {
                    swap = right;
                }
            }

            if (swap === null) break;

            [this.heap[index], this.heap[swap]] = [this.heap[swap], this.heap[index]];
            index = swap;
        }
    }
}

heap = new AbsHeap();

for (let i=0; i<T; i++){
    let x = Number(input[i]);
    if (x === 0) {
        console.log(heap.extract());
    } else {
        heap.insert(x);
    }
}