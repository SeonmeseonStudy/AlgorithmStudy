const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split("\n").map(i => i.trim());

    const nums = input.slice(1).map(Number);

    for (let num of nums) {
        let val = num;
        while (!isPrime(val)) {
            val++;
        }
        console.log(val);
    }
}
const isPrime = (val) => {
    if (val === 1 || val === 0) return false;
    for (let i = 2; i <= Math.sqrt(val); i++) {
        if (val % i === 0) return false;
    }
    return true;
}
main();