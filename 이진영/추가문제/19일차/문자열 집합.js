const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const [n, m] = input[0].split(" ").map(Number);
    const s = new Set(input.slice(1, 1 + n));
    const strs = input.slice(1 + n);

    console.log(strs.filter(str => s.has(str)).length);
}
main();