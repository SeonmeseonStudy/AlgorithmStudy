const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split(' ').map(Number));

let Ix = [0, 0, 0, 0], Iy = [0, 1, 2, 3];
let Ix2 = [0, 1, 2, 3], Iy2 = [0, 0, 0, 0];

let Ox = [0, 0, 1, 1], Oy = [0, 1, 0, 1];

let Tx = [0, 1, 1, 1], Ty = [1, 0, 1, 2];
let Tx2 = [1, 0, 1, 2], Ty2 = [0, 1, 1, 1];
let Tx3 = [0, 0, 0, 1], Ty3 = [0, 1, 2, 1];
let Tx4 = [0, 1, 2, 1], Ty4 = [0, 0, 0, 1];

let Lx = [0, 1, 2, 2], Ly = [0, 0, 0, 1];
let Lx2 = [0, 0, 0, 1], Ly2 = [0, 1, 2, 2];
let Lx3 = [0, 1, 2, 0], Ly3 = [1, 1, 1, 0];
let Lx4 = [0, 1, 1, 1], Ly4 = [0, 0, 1, 2];

let Jx = [0, 1, 2, 2], Jy = [1, 1, 1, 0];
let Jx2 = [0, 0, 0, 1], Jy2 = [0, 1, 2, 0];
let Jx3 = [0, 1, 2, 0], Jy3 = [0, 0, 0, 1];
let Jx4 = [0, 1, 1, 1], Jy4 = [2, 2, 1, 0];

let Sx = [0, 0, 1, 1], Sy = [1, 2, 0, 1];
let Sx2 = [0, 1, 1, 2], Sy2 = [0, 0, 1, 1];

let Zx = [0, 0, 1, 1], Zy = [0, 1, 1, 2];
let Zx2 = [0, 1, 1, 2], Zy2 = [1, 1, 0, 0];

const tetrominoes = {
    I: [[Ix, Iy], [Ix2, Iy2]],
    O: [[Ox, Oy]],
    T: [[Tx, Ty], [Tx2, Ty2], [Tx3, Ty3], [Tx4, Ty4]],
    L: [[Lx, Ly], [Lx2, Ly2], [Lx3, Ly3], [Lx4, Ly4]],
    J: [[Jx, Jy], [Jx2, Jy2], [Jx3, Jy3], [Jx4, Jy4]],
    S: [[Sx, Sy], [Sx2, Sy2]],
    Z: [[Zx, Zy], [Zx2, Zy2]],
};

function inrange(x, y){
    return 0 <= x && x < N && 0 <= y && y < M;
}

function calcTerominoes(dxs, dys){
    let sumValue = 0;
    for (let i=0; i<N; i++) {
        for (let j=0; j<M; j++) {
            let value = 0;
            let isSafe = true;

            for (let d=0; d<4; d++){
                let dx = i+dxs[d], dy = j+dys[d];
                if (inrange(dx, dy)) {
                    value += board[dx][dy];
                } else {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                sumValue = Math.max(sumValue, value);
            }
        }
    }

    return sumValue;
}

let maxValue = 0;
for (let type in tetrominoes){
    let typeNum = tetrominoes[type].length;
    for (let i=0; i<typeNum; i++){
        let [dxs, dys] = tetrominoes[type][i];
        let result = calcTerominoes(dxs, dys);

        maxValue = Math.max(maxValue, result);
    }
}

console.log(maxValue);