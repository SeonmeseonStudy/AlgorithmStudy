// min heap 구현
class Heap {
    constructor(arr) {
        this.heap = [];
        
        for (const num of arr) {
            this.push(num);
        }
    }
    
    size() {
        return this.heap.length;
    }
    
    // 모든 스코빌 지수가 k 이상인지 체크
    confirm(k) {
        return this.heap.every(i => i >= k);
    }
    
    swap(idx1, idx2) {
        [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
    }
    
    push(val) {
        this.heap.push(val);
        
        let index = this.size() - 1;
        let parentIndex = Math.floor((index - 1) / 2);
        
        while (
            this.heap[index] && this.heap[parentIndex] &&
            this.heap[index] < this.heap[parentIndex]
        ) {
            this.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = Math.floor((index - 1) / 2);
        }
    }
    
    pop() {
        if (this.size() === 0) return null;
        if (this.size() === 1) return this.heap.pop();
        
        let ret = this.heap[0];
        
        this.heap[0] = this.heap.pop();
        
        let index = 0;
        let left = 2 * index + 1;
        let right = 2 * index + 2;
        
        while (
            this.heap[left] && this.heap[left] < this.heap[index] ||
            this.heap[right] && this.heap[right] < this.heap[index]
        ) {
            let smaller = !this.heap[right] 
            || this.heap[left] <= this.heap[right] ? left : right;
            
            this.swap(smaller, index);
            index = smaller;
            left = 2 * index + 1;
            right = 2 * index + 2
        }
        
        return ret;
    }
    
    // 음식 섞기
    mix() {
        let a = this.pop();
        let b = this.pop();
        
        this.push(a + b * 2);
    }
}

function solution(scoville, K) {
    let heap = new Heap(scoville); // 스코빌 지수 오름차순으로 정렬
    let count = 0; // 믹스 횟수
    
    while (true) {
        if (heap.confirm(K)) return count; // 조건 달성 시 return
        if (heap.size() === 1) return -1; // 스코빌을 모두 섞어 하나만 남으면 -1 반환
        
        heap.mix();
        count++;
    }
}