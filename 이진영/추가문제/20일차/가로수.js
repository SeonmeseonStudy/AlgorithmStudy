const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const n = Number(input[0]);
    const nums = input.slice(1).map(Number);

    let dists = new Set();
    for (let i = 1; i < n; i++) {
        dists.add(nums[i] - nums[i - 1]);
    }

    let distsArr = [...dists].sort((a, b) => a - b);
    let dist = 1;

    for (let i = distsArr[0]; i > 1; i--) {
        if (distsArr.every(val => val % i === 0)) {
            dist = i;
            break;
        }
    }

    console.log((nums[n - 1] - nums[0]) / dist - n + 1);
}
main();