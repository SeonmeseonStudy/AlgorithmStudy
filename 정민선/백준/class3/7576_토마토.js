const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [M, N] = input.shift().split(' ').map(Number);
let tomatoes = input.map(e => e.split(' ').map(Number));
let queue = [];
let dxs = [0, 1, 0, -1];
let dys = [1, 0, -1, 0];

function inrange(x, y) {
    return 0 <= x && x < N && 0 <= y && y < M;
}

for (let i=0; i<N; i++){
    for (let j=0; j<M; j++){
        if (tomatoes[i][j] === 1) {
            queue.push([i, j]);
        }
    }
}

function search(){
    let count = -1;
    let index = 0;
    while (queue.length > index) {
        let size = queue.length - index;
        count++;

        for (let s = 0; s < size; s++) {
            let [x, y] = queue[index++];

            for (let k = 0; k < 4; k++) {
                let nx = x + dxs[k];
                let ny = y + dys[k];

                if (inrange(nx, ny) && tomatoes[nx][ny] === 0) {
                    tomatoes[nx][ny] = 1;
                    queue.push([nx, ny]);
                }
            }
        }
    }
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (tomatoes[i][j] === 0) {
                return -1;
            }
        }
    }
    return count;
}
console.log(search());