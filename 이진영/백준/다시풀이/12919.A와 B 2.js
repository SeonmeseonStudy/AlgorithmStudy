const [S, T] = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");


const bfs = () => {
    let q = [T];

    while (q.length) {
        const cur = q.shift();

        if (cur === S) {
            return 1;
        }

        if (cur.length === S.length) continue;

        if (cur[cur.length - 1] === "A") {
            q.push(cur.slice(0, cur.length - 1));
        }

        if (cur[0] === "B") {
            q.push(cur.slice(1).split("").reverse().join(""));
        }
    }
    return 0;
}

console.log(bfs());