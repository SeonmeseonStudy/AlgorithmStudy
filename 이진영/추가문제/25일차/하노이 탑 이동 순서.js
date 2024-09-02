const n = Number(require('fs').readFileSync('dev/stdin').toString().trim());
let step = [];

const hanoi = (n, start, end) => {
    if (n === 1) step.push([start, end]);
    else {
        hanoi(n - 1, start, 6 - start - end);
        step.push([start, end]);
        hanoi(n - 1, 6 - start - end, end);
    }
}

hanoi(n, 1, 3);
console.log(step.length);
console.log(step.map(i => i.join(" ")).join("\n"));