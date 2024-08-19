const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const n = Number(input[0].split(" ")[0])
    const s1 = new Set(input.slice(1, 1 + n));
    const s2 = input.slice(1 + n).sort().filter(i => s1.has(i));

    console.log(s2.length);
    console.log(s2.join("\n"));
}
main();