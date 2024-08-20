const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split(" ").map(Number);

    const [m, n] = input;

    let arr = Array(n + 1).fill(0).map((_, i) => i);
    arr[0] = 0;
    arr[1] = 0;

    for (let i = 2; i <= n; i++) {
        if (arr[i] === 0) continue;

        for (let j = 2 * i; j <= n; j+=i) {
            arr[j] = 0;
        }
    }

    console.log(arr.filter((v, i) => v > 0 && i >= m).join("\n"));
}

main();