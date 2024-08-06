// 힙 구현
class Heap {
    constructor() {
        this.heap = [];
    }
    
    size() {
        return this.heap.length;
    }
    
    swap(idx1, idx2) {
        [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]]
    }
    
    maxAndMin() {
        if (this.size() > 0) {
            this.sortLastNodes();
            return [this.heap[this.size() - 1], this.heap[0]]
        } else return [0, 0];     
    }
    
    // 리프노드에서 제일 큰 노드를 맨 마지막에 배치
    sortLastNodes() {
        if (this.size() > 2) {
            let i = this.size() - 1;
            let p = Math.floor((i - 1) / 2); // 마지막 노드의 부모 노드 (리프노드 기준)
            let slice = this.heap.slice(p);
            let maxIndex = slice.indexOf(Math.max(...slice));

            this.swap(p + maxIndex, i);
        }
    }
    
    push(val) {
        this.heap.push(val);
        
        let i = this.size() - 1;
        let p = Math.floor((i - 1) / 2);
        
        while (this.heap[p] !== undefined && this.heap[i] < this.heap[p]) {
            this.swap(i, p);
            i = p;
            p = Math.floor((i - 1) / 2);
        }
    }
    
    popMax() {
        if (!this.size()) return null;
        this.sortLastNodes();
        return this.heap.pop();
    }
    
    popMin() {
        if (!this.size()) return null;
        if (this.size() === 1) return this.heap.pop();
        
        let ret = this.heap[0];
        this.heap[0] = this.heap.pop();
        
        let i = 0;
        let l = i * 2 + 1;
        let r = i * 2 + 2;
        
        while (this.heap[l] !== undefined && this.heap[l] < this.heap[i]
              || this.heap[r] !== undefined && this.heap[r] < this.heap[r]) {
            let smaller = !this.heap[r] || this.heap[l] <= this.heap[r] ? l : r;
            
            this.swap(i, smaller);
            
            i = smaller;
            l = i * 2 + 1;
            r = i * 2 + 2;
        }
        
        return ret
    }
}

function solution(operations) {
    let heap = new Heap();
    
    for (let oper of operations) {
        if (oper.charAt(0) === "I") {
            heap.push(Number(oper.split(" ")[1]));
        } else if (oper === "D -1") {
            heap.popMin();
        } else if (oper === "D 1") {
            heap.popMax();
        }
    }
    
    return heap.maxAndMin();
}