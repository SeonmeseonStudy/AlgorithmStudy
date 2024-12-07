const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split(" ").map(Number);
let [n, k] = [input[0], input[1]];
let visited = Array(100001).fill(false);
let deque = []; 
deque.push([n, 0]);

while (deque.length) {
    let [position, count] = deque.shift();

    if (position === k) {
        console.log(count);
        break;
    }

    if (position * 2 <= 100000 && !visited[position * 2]) {
        visited[position * 2] = true;
        deque.unshift([position * 2, count+1]);
    }

    if (position + 1 <= 100000 && !visited[position + 1]) {
        visited[position + 1] = true;
        deque.push([position + 1, count + 1]);
    }

    if (position - 1 >= 0 && !visited[position - 1]) {
        visited[position - 1] = true;
        deque.push([position - 1, count + 1]);
    }
}
