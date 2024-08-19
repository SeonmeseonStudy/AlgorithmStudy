const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const [n, m] = input[0].split(" ").map(Number);
    const pokets = input.slice(1, 1 + n);
    const problems = input.slice(1 + n);

    let map = new Map();
    pokets.forEach((v, i) => {
        const num = (i + 1).toString();
        map.set(v, num);
        map.set(num, v);
    })

    problems.forEach(val => {
        console.log(map.get(val));
    })
}
main();