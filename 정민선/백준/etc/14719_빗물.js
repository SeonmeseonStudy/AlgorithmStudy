const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [height, width] = input[0].split(' ').map(Number);
let blocks = input[1].split(' ').map(Number);

let rain = 0;
let left = 0, right = width - 1;
let leftMax = blocks[left], rightMax = blocks[right];

while (left <= right) {
    if (leftMax <= rightMax) {
        if (blocks[left] < leftMax) {
            rain += leftMax - blocks[left];
        } else {
            leftMax = blocks[left];
        }
        left++;
    } else {
        if (blocks[right] < rightMax) {
            rain += rightMax - blocks[right];
        } else {
            rightMax = blocks[right];
        }
        right--;
    }
}

console.log(rain);