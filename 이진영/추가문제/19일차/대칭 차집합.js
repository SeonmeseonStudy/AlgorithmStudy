const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const [n, m] = input[0].split(" ").map(Number);

    const s1 = new Set(input[1].split(" ").map(Number));
    const s2 = new Set(input[2].split(" ").map(Number));

    let count = 0;
    for (let item of s2) {
        if (s1.has(item)) count++;
    }

    console.log(n + m - 2 * count);
}
main();