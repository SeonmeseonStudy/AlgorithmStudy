const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const cds = input[1].split(" ").map(Number);

    console.log(Math.min(...cds) * Math.max(...cds));
}

main();