const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").slice(1);

    console.log(input.filter((val, idx) => input.indexOf(val) === idx).sort((a, b) => {
        if (a.length === b.length) {
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        return a.length - b.length;
    }).join("\n"));
}

main();