const reader = require('readline').Interface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
})

let n; // 최대 5만
let answer = 0;
let st = [];
reader.on('line', line => {
    if (n === undefined) n = +line.trim();
    else {
        const [_, y] = line.trim().split(" ").map(Number);
        while (st.length && st[st.length - 1] > y) {
            st.pop();
            answer++;
        }

        if (st.length === 0 || st[st.length - 1] < y) st.push(y)
    }
}) 

reader.on('close', () => {
    console.log(answer + st.reduce((p, n) => n ? p + 1 : p, 0));
})