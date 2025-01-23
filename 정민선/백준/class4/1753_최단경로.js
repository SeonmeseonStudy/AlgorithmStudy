const { deepStrictEqual } = require('assert');
const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [V, E] = input.shift().split(' ').map(Number);
const K = Number(input.shift());

let graph = Array.from({length : V+1}, () => []);
for (let data of input) {
    let [u, v, w] = data.split(' ').map(Number);
    graph[u].push([v, w]);
}

class MinHeap {
    constructor(){
        this.heap = [];
    }
    push(value){
        this.heap.push(value);
        this.bubbleUp();
    }
    pop(){
        if (this.size === 1) return this.heap.pop();
        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return top;
    }
    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0){
            const parent = Math.floor((index-1)/2);
            if (this.heap[index][0] >= this.heap[parent][0]) break;
            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];
            index = parent;
        }
    }
    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        while (true) {
            const left = 2*index+1;
            const right = 2*index+2;
            let smallest = index;

            if (left < length && this.heap[left][0] < this.heap[smallest][0]) smallest = left;
            if (right < length && this.heap[right][0] < this.heap[smallest][0]) smallest = right;
            if (smallest === index) break;
            [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
            index = smallest;
        }
    }
    get size() {
        return this.heap.length;
    }
}

function dijkstra(start) {
    const distances = Array(V+1).fill(Infinity);
    distances[start] = 0;
    const queue = new MinHeap();
    queue.push([0, start]);
    
    while (queue.size > 0) {
        let [dist, node] = queue.pop();
        if (dist > distances[node]) continue;

        for (let [next, weight] of graph[node]) {
            let newDist = dist+weight;
            if (newDist < distances[next]) {
                distances[next] = newDist;
                queue.push([newDist, next]);
            }
        }
    }
    return distances
}

let answer = dijkstra(K);
console.log(answer.slice(1).map(result => result === Infinity? 'INF': result).join('\n'));