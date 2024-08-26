const n = Number(require('fs').readFileSync('dev/stdin')
        .toString().trim())

const k = Math.log(n) / Math.log(3);

let arr = Array.from(new Array(n), () => new Array(n).fill(true));

let size = n;
while (size > 1) {
    size = size/3;

    for (let i = size; i < n; i += size * 3) {
        for (let j = size; j < n; j += size * 3) {
            for (let k1 = i; k1 < i + size; k1++) {
                for (let k2 = j; k2 < j + size; k2++) {
                    arr[k1][k2] = false;
                }
            }
        }
    }
}

console.log(arr.map(row => row.map(i => i ? "*" : " ").join("")).join("\n"))