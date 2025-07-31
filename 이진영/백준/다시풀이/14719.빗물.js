const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const [H, W] = input[0].split(" ").map(Number);
const heights = input[1].split(" ").map(Number);

let leftMax = new Array(W).fill(0);
let rightMax = new Array(W).fill(0);

leftMax[0] = heights[0];
for (let i = 1; i < W; i++) {
    leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
}

rightMax[W - 1] = heights[W - 1];
for (let i = W - 2; i >= 0; i--) {
    rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
}

let result = 0;
for (let i = 0; i < W; i++) {
    result += Math.min(leftMax[i], rightMax[i]) - heights[i];
}

console.log(result);
