const main = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim();
    console.log(input.split("").sort((a, b) => Number(b) - Number(a)).join(""));
}

main();