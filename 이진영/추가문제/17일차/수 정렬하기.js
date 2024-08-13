const main = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n");
    const arr = input.slice(1).map(i => Number(i.trim()));

    console.log(arr.sort((a, b) => a - b).join("\n"));
}

main();