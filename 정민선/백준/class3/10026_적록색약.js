const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let board = input.map(e => e.split(''));
let result = [];
let visited = Array.from({length: N}, () => Array(N).fill(false));
let dxs = [0, 1, 0, -1], dys = [1, 0, -1, 0];

function inrange(x, y){
    return 0 <= x && x < N && 0 <= y && y < N;
}

function search(x, y, type){
    let color = board[x][y]; 
    visited[x][y] = true;
    let queue = [[x, y]];

    while(queue.length > 0){
        let [nx, ny] = queue.shift();
        for (let k=0; k<4; k++){
            let dx = nx+dxs[k], dy = ny+dys[k];
            
            if (inrange(dx, dy) && !visited[dx][dy]) {
                if (type){
                    if (color === 'B' && board[dx][dy] === color) {
                        visited[dx][dy] = true;
                        queue.push([dx, dy]);
                    } else {
                        if ((color === 'R' || color === 'G') && (board[dx][dy] === 'R' || board[dx][dy] === 'G')) {
                            visited[dx][dy] = true;
                            queue.push([dx, dy]);
                        }
                    }
                } else if (!type && board[dx][dy] === color) {
                    visited[dx][dy] = true;
                    queue.push([dx, dy]);
                }
            }
        }
    }
}

function countRegions(type) {
    let count = 0;
    visited = Array.from({ length: N }, () => Array(N).fill(false));
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (!visited[i][j]) {
                search(i, j, type);
                count++;
            }
        }
    }
    return count;
}
result.push(countRegions(false));
result.push(countRegions(true));
console.log(result.join(' '));