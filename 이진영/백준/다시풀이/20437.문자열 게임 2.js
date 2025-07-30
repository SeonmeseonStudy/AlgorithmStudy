const reader = require('readline').createInterface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
});

let T;
let W, K;
let answers = [];

reader.on('line', (line) => {
    if (!T) {
        T = Number(line);
    } else if (!W) {
        W = line;
    } else {
        K = Number(line);

        getLength();

        W = undefined;
        K = undefined;
    }
});

reader.on('close', () => {
    console.log(answers.join("\n"));
})

function getLength() {
    let idxs = new Map();
    let result1 = Infinity;
    let result2 = 0;

    for (let i = 0; i < W.length; i++) {
        const c = W[i];
        if (!idxs.has(c)) {
            idxs.set(c, []);
        }

        idxs.get(c).push(i);

        const arr = idxs.get(c)

        if (arr.length >= K) {
            const l = i - arr[arr.length - K] + 1;
            result1 = Math.min(result1, l);
            result2 = Math.max(result2, l);
        }
    }

    if (result1 === Infinity || result2 === Infinity) {
        answers.push("-1");
    } else {
        answers.push(`${result1} ${result2}`);
    }
}