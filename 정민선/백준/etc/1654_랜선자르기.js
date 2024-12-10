const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');

const [K, N] = input[0].split(' ').map(Number);
const lengths = input.slice(1).map(Number);

let result = 0;
let [left, right] = [0, Math.max(...lengths)];

while (left <= right) {
    let mid = Math.floor((left+right)/2);
    let count = 0;
    for (let length of lengths) {
        count += Math.floor(length/mid)
    }

    if (count >= N) {
        result = mid;
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
console.log(result)