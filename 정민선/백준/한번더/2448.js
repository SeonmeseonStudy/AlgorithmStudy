const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
let N = Number(input);

let stars = Array.from({length : N}, () => Array(N*2 -1).fill(' '));

function printStars(num, x, y) {
    if (num === 3) {
        stars[x][y+2] = '*';
        stars[x+1][y+1] = '*'
        stars[x+1][y+3] = '*';
        for(let i=0; i<5; i++) {
            stars[x+2][y+i] = '*';
        }
        return;
    }

    let half = num/2;
    printStars(half, x, y+half);
    printStars(half, x+half, y);
    printStars(half, x+half, y+num);
}

printStars(N, 0, 0);
console.log(stars.map(e => e.join('')).join('\n'));