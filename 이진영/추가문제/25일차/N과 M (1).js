const [n, m] = require('fs').readFileSync('dev/stdin').toString().trim().split(" ").map(Number);

const select = (arr, n) => {
    if (n === 1) {
        return arr.map(i => [i]);
    } else {
        let ret = [];
        for (let i = 0; i < arr.length; i++) {
            const subArr = arr.slice(0, i).concat(arr.slice(i + 1));
            ret = ret.concat(select(subArr, n - 1).map(v => [arr[i], ...v]));
        }
        return ret;
    }
}
let arr = [];
for (let i = 1; i <= n; i++) {
    arr.push(i);
}

console.log(select(arr, m).map(i => i.join(" ")).join("\n"));