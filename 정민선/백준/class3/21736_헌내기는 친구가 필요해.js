const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split(''));

// O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.


function findDoyeon(){
    for (let i=0; i<N; i++){
        for (let j=0; j<M; j++){
            if (board[i][j] === 'I') {
                return [i, j];
            }
        }
    }
}

function inrange(x, y){
    return 0 <= x && x < N && 0 <= y && y < M;
}

function canMeet(x, y){
    let count = 0;
    let queue = [[x, y]];
    let dxs = [0, 1, 0, -1];
    let dys = [1, 0, -1, 0];
    let visited = Array.from({length : N}, () => Array(M).fill(false));
    // visited[x][y] = true;

    while (queue.length > 0) {
        let [dx, dy] = queue.shift();

        for (let d=0; d<4; d++){
            let nx = dxs[d]+dx;
            let ny = dys[d]+dy;

            if (inrange(nx, ny) && !visited[nx][ny] && board[nx][ny] !== 'X'){
                if (board[nx][ny] === 'P') {
                    count++;
                }
                visited[nx][ny] = true;
                queue.push([nx, ny]);
            }
        }
    }
    return count? count : 'TT';
}

let [sx, sy] = findDoyeon();
let answer = canMeet(sx, sy);
console.log(answer);