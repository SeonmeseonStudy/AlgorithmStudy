const main = () => {
    const input = require('fs').readFileSync('../dev/stdin').toString().trim().split("\n");

    const coords = input.slice(1).map(i => i.trim().split(" ").map(Number));

    console.log(coords.sort((a, b) => {
        if (a[1] === b[1]) return a[0] - b[0];
        else return a[1] - b[1];
    }).map(i => i.join(" ")).join("\n"));
}

main();