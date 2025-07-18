const [n, k] = require('fs').readFileSync('dev/stdin').toString().trim().split(" ").map(Number);

let visited = new Set();

let q = [[n, 0]];
let h = 0;

while (h < q.length) {
    let [cur, cnt] = q[h++];

    if (cur === k) {
        console.log(cnt);
        break;
    }

    if (cur * 2 <= 100000 && !visited.has(cur * 2)) {
        visited.add(cur * 2);
        q.push([cur * 2, cnt + 1]);
    }

    if (cur + 1 <= 100000 && !visited.has(cur + 1)) {
        visited.add(cur + 1);
        q.push([cur + 1, cnt + 1]);
    }

    if (cur - 1 >= 0 && !visited.has(cur - 1)) {
        visited.add(cur - 1);
        q.push([cur - 1, cnt + 1]);
    }
}