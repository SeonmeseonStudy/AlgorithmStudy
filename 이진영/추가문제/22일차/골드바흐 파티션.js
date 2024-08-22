const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split("\n").map(i => Number(i.trim()));
    const n = input[0];
    const nums = input.slice(1);
    const MAX = 1000000

    let arr = Array(MAX + 1).fill(1).map((_, i) => i);
    arr[0] = 0;
    arr[1] = 0;

    for (let i = 2; i <= MAX; i++) {
        if (arr[i]) {
            for (let j = i * 2; j <= MAX; j+=i) {
                arr[j] = 0;
            }
        }
    }

    nums.forEach(num => {
        let count = 0;

        for (let i = 2; i <= Math.floor(num / 2); i++) {
            if (arr[i] && arr[num - i]) count++;
        }

        console.log(count);
    })
}

main();

