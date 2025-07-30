const input =  require('fs').readFileSync('dev/stdin').toString().trim().split("\n");
const n = +input[0].trim();
const arr = input[1].trim().split(" ").map(Number);

let idx = new Map();
let stack = [];
let answer = [];

for (let i = 0; i < n; i++) {
    const sig = arr[i]

    while (stack.length) {
        const j = stack.pop();
        if (arr[j] > sig) {
            stack.push(j);
            answer.push(j + 1);
            break;
        }
    }

    stack.push(i)
    if (!answer[i]) answer[i] = 0;
}

console.log(answer.join(" "))