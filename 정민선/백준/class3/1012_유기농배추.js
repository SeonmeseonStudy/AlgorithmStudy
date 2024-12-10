const { kMaxLength } = require('buffer');
const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let T = Number(input.shift());

for (let i=1; i<=T; i++){
    let [M, N, K] = input.shift().split(' ').map(Number);
    let cabbages = Array(N).fill(0).map(e => Array(M).fill(0));
    let visited = Array(N).fill(0).map(e => Array(M).fill(false));
    
    function inrange(x, y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    function bfs(x, y){
        let dxs = [0, 1, 0, -1], dys = [1, 0, -1, 0];
        let queue = [[x,y]];
        
        while (queue.length){
            let [cx, cy] = queue.shift();
            for (let k=0; k<4; k++){
                let nx = cx + dxs[k];
                let ny = cy + dys[k];

                if (inrange(nx, ny) && cabbages[nx][ny] === 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.push([nx, ny]);
                }
            }
        }
        return 1;
    }

    for (let j=0; j<K; j++){
        let [y, x] = input.shift().split(' ').map(Number);
        cabbages[x][y] = 1;
    }

    let count = 0;
    for (let x=0; x<N; x++){
        for (let y=0; y<M; y++){
            if (cabbages[x][y] === 1 & !visited[x][y]){
                visited[x][y] = true;
                count += bfs(x, y);
            }
        }
    }
    console.log(count);
}
