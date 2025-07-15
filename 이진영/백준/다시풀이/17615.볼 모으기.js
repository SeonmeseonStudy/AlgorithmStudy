const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const n = +input[0];
const rbs = input[1].split("");
let min = Infinity;

let rflag = false;
let bflag = false;

let rsum = 0;
let bsum = 0;

for (let i = 0; i < n; i++) {
    if (!rflag && rbs[i] === "R") {
        rflag = true;
    }

    if (!bflag && rbs[i] === "B") {
        bflag = true;
    }

    if (bflag && rbs[i] === "R") rsum++;
    if (rflag && rbs[i] === "B") bsum++;
}

min = Math.min(min, rsum, bsum);

rflag = false;
bflag = false;

rsum = 0;
bsum = 0;

for (let i = n - 1; i >= 0; i--) {
    if (!rflag && rbs[i] === "R") {
        rflag = true;
    }

    if (!bflag && rbs[i] === "B") {
        bflag = true;
    }

    if (bflag && rbs[i] === "R") rsum++;
    if (rflag && rbs[i] === "B") bsum++;
}

min = Math.min(min, rsum, bsum);

console.log(min);