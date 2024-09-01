const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const [n, m]= input[0].split(" ").map(Number);
    const words = input.slice(1).filter(i => i.length >= m);

    let freq = new Map();
    words.forEach(word => {
        if (!freq.has(word)) {
            freq.set(word, 1);
        } else {
            freq.set(word, freq.get(word) + 1);
        }
    })

    console.log([... new Set(words)].sort((a, b) => {
        if (freq.get(a) !== freq.get(b)) return freq.get(b) - freq.get(a);
        else if (a.length !== b.length) return b.length - a.length;
        else {
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }
    }).join("\n"));
}

main();