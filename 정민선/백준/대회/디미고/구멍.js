const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim();
let strings = input.split('');

let holes = [
    1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,
    0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,
    0, 0,
];

let result = 0;
for (let s of strings) {
    if (s === "@") {
        result += 1;
        continue;
    }
    if (s === ' ' ) continue;

    let n = s.charCodeAt();
    if (n > 64 && n < 91) {
        n = n - 65;
    } else {
        n -= (97 - 26);
    }
    result += holes[n];
}

console.log(result);
