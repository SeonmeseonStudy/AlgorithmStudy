const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split(" ").map(Number);

    const n = input[0];
    const k = input[1];

    console.log(factorial(n) / factorial(k) / factorial(n - k));
}

const factorial = (n) => {
    if (n === 1 || n === 0) return 1;
    return n * factorial(n - 1);
}

main();