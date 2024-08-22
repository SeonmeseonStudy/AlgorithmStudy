const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim();
    const [n, k] = input.split(" ").map(Number);

    let nums = [];
    for (let i = 1; i <= n; i++) {
        nums.push(i);
    }
    let answer = [];
    let count = 1;

    while (nums.length > 0) {
        while (count < k) {
            nums.push(nums.shift());
            count++;
        }
        answer.push(nums.shift());
        count = 1;
    }

    console.log("<" + answer.join(", ") + ">")
}

main();