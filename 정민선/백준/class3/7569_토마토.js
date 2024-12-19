const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [M, N, H] = input.shift().split(' ').map(Number);
let tomatoes = [];

for (let h=0; h<N*H; h+=N){
    let layer = input.slice(h, h+N).map(e => e.split(' ').map(Number));
    tomatoes.push(layer);
}

let dxs = [0, 1, 0, -1, 0, 0];
let dys = [1, 0, -1, 0, 0, 0];
let dhs = [0, 0, 0, 0, 1, -1];

function inrange(x, y, z){
    return 0 <= x && x < N && 0 <= y && y < M && 0 <= z && z < H;
}

function bfs(){
    let queue = [];
    let visited = Array.from({ length: H }, () => Array.from({ length: N }, () => Array(M).fill(false)));
    for (let h=0; h<H; h++){
        for (let n=0; n<N; n++){
            for (let m=0; m<M; m++){
                if (tomatoes[h][n][m] === 1){
                    queue.push([h, n, m, 0]);
                    visited[h][n][m] = true;
                }
            }
        }
    }

    let day = 0;
    let start = 0;
    while (queue.length > start){
        let [z, x, y, d] = queue[start++];
        day = d;
        for (let c=0; c<6; c++){
            let dx = x+dxs[c];
            let dy = y+dys[c];
            let dh = z+dhs[c];

            if (inrange(dx, dy, dh) && !visited[dh][dx][dy] && tomatoes[dh][dx][dy] === 0){
                tomatoes[dh][dx][dy] = 1;
                visited[dh][dx][dy] = true;
                queue.push([dh, dx, dy, day+1]);
            }
        }
    }
    return day;
}
let day = bfs();

for (let h=0; h<H; h++){
    for (let n=0; n<N; n++){
        for (let m=0; m<M; m++){
            if (tomatoes[h][n][m] === 0){
                console.log(-1);
                return 0;
            }
        }
    }
}

console.log(day);