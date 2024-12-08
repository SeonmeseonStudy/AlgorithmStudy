const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split(' ');
const [N, R, C] = input.map(Number);
let M = Math.pow(2, N);

function findZ(x, y, size, start) {
    if (size === 1){
        return start;
    }

    let halfSize = size/2;
    if (x < halfSize && y < halfSize){
        return findZ(x, y, halfSize, start);
    }
    if (x < halfSize && y >= halfSize) {
        return findZ(x, y-halfSize, halfSize, start+halfSize*halfSize);
    }
    if (x >= halfSize && y < halfSize) {
        return findZ(x-halfSize, y, halfSize, start + 2*halfSize*halfSize);
    }
    if (x >= halfSize && y >= halfSize) {
        return findZ(x-halfSize, y-halfSize, halfSize, start + 3*halfSize*halfSize);
    }
}

let result = findZ(R, C, M, 0);
console.log(result);