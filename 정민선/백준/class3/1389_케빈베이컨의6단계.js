const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let friends = Array.from({length:N+1}, ()=> []);

for (let data of input){
    let [a, b] = data.split(' ').map(Number);
    friends[a].push(b);
    friends[b].push(a);
}

let result = Array(N+1).fill(0);

function bfs(start, end){
    queue = [];
    visited = Array(N+1).fill(false);
    queue.push([start, 0])
    visited[start] = true;
    while (queue.length > 0){
        let [next, num] = queue.shift();
        if (next === end){
            return num;
        }
        for (let friend of friends[next]){
            if (!visited[friend]){
                visited[friend] = true;
                queue.push([friend, num+1]);
            }
        }
        
    }
}

function search(user){
    let sum = 0;
    for (let i=1; i<=N; i++){
        sum += bfs(user, i);
    }
    return sum;
}

for (let i=1; i<=N; i++){
    result[i] = search(i);
}

let minValue = Math.min(...result.filter(num => num !== 0));
console.log(result.findIndex(num => num === minValue));