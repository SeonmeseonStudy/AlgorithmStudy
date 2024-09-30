const [n, m] = require('fs').readFileSync('dev/stdin').toString().trim().split(" ").map(Number);

let nums = [];
for (let i = 1; i <= n; i++) {
    nums.push(i);
}

let answer = [];

const func = (arr) => {
    const l = arr.length;

    if (l === m) {
        answer.push(arr);
        return;
    }

    for (let i = 0; i < n; i++) {
        if ((nums[i] >= arr[l - 1]) || l === 0) {
            func([...arr, nums[i]]);
        }
    }
}

func([]);

console.log(answer.map(i => i.join(" ")).join("\n"));
