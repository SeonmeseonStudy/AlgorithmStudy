const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let board = [...Array(101)].map((_, index) => index);

for (let data of input){
    let [x, y] = data.split(' ').map(Number);
    board[x] = y
}

let visited = Array(101).fill(false);
let queue = [];

queue.push([1, 0]);
visited[1] = true;

while (queue.length > 0){
    let [current, count] = queue.shift();
    if (current === 100) {
        console.log(count);
        break;
    }
    for (let dice=1; dice<7; dice++){
        let next = current+dice;
        if (next < 101 && !visited[next]){
            visited[next] = true;
            if (board[next] !== next) {
                queue.push([board[next], count + 1]);
            } else {
                queue.push([next, count + 1]);
            }
        } else if (next > 101){
            break;
        }
    }
}