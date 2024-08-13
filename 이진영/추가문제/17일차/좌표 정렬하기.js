const main = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n");

    const n = Number(input[0].trim());
    const coords = input.slice(1).map(i => i.trim().split(" ").map(Number));

    console.log(coords.sort((a, b) => {
        if (a[0] === b[0]) return a[1] - b[1];
        else return a[0] - b[0];
    }).map(i => i.join(" ")).join("\n"));
}

main();