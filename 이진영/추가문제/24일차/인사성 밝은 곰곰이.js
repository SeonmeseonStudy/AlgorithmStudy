const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const n = Number(input[0]);
    const strs = input.slice(1);
    let set = new Set();
    let answer = 0;

    for (let i = 1; i < n; i++) {
        if (strs[i] === "ENTER") {
            set = new Set();
        } else {
            if (!set.has(strs[i])) {
                set.add(strs[i]);
                answer++;
            }
        }
    }

    console.log(answer);
}

main();