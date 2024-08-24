let fac = Array(31).fill(-1);
fac[0] = 1;
fac[1] = 1;

const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const t = Number(input[0]);
    const cases = input.slice(1).map(i => i.split(" ").map(Number));

    cases.forEach(item => {
        console.log(comb(item[0], item[1]));
    })
}

const comb = (n, m) => {
    if (n === 1) return m;
    if (n === m) return 1;
    return Math.round(factorial(m)/factorial(n)/factorial(m - n));
}

const factorial = (n) => {
    if (fac[n] === -1) fac[n] = n * factorial(n - 1);
    return fac[n];
}

main();
