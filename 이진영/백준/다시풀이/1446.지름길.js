const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const [n, d] = input[0].split(" ").map(Number);
const roads = input.slice(1).map(v => v.split(" ").map(Number))

let map = new Map();
let set = new Set();

for (let [s, e, c] of roads) {
    if (!map.has(s)) {
        map.set(s, []);
    }
    map.get(s).push([e, c]);
    set.add(s);
}

let min = d;
let q = [[0, 0]];

while (q.length) {
    const [p, c] = q.shift();
    min = Math.min(min, c + d - p);

    for (let next of set) {
        if (next >= p) {
            for (let [e, c2] of map.get(next) ?? []) {
                if (e <= d) {
                    q.push([e, c + c2 + next - p]);
                }
            }
        }
    }
}

console.log(min);