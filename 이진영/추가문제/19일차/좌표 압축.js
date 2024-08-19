const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n")[1].split(" ").map(Number);
    const sorted = [...new Set(input)].sort((a, b) => a - b);

    let map = new Map();
    sorted.forEach((val, idx) => {
        map.set(val, idx);
    })

    console.log(input.map(i => map.get(i)).join(' '));
}
main();