const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const n = Number(input[0]);

    const abs = input.slice(1).map(i => i.split(" "));
    let set = new Set();
    set.add("ChongChong");

    for (let i = 0; i < n; i++) {
        if (set.has(abs[i][0]) || set.has(abs[i][1])) {
            set.add(abs[i][0]);
            set.add(abs[i][1]);
        }
    }
    console.log(set.size);
}

main();