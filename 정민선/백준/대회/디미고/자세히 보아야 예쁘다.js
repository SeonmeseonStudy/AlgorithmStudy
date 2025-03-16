const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let numbers = input[1].split(" ").map(Number);

let total = 0;
for (let time of numbers) {
    total += time-1;
}

if (total >= m) {
    console.log('DIMI');
} else {
    console.log('OUT');
}