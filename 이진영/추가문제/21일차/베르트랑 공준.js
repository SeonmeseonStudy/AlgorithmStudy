const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split("\n").map(i => Number(i.trim()));
    const n = 123456 * 2

    let arr = Array(n + 1).fill(0).map((_, i) => i);
    arr[0] = 0;
    arr[1] = 0;

    for (let i = 2; i <= n + 1; i++) {
        if (arr[i] === 0) continue;
        for (let j = i * 2; j <= n + 1; j += i) {
            arr[j] = 0;
        }
    }
    
    input.slice(0, input.length - 1).forEach(num => {
        console.log(arr.filter((v, i) => i > num && i <= num * 2 && v > 0).length);
    })
}

main();