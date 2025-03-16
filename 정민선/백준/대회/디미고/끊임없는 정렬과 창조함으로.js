const fs = require("fs");
let input = fs
    .readFileSync("./정민선/백준/input.txt")
    .toString()
    .trim()
    .split("\n");
let q = Number(input.shift());

let result = [];

for (let data of input) {
    let query = data.split(" ").map(Number);

    if (query[0] === 1) {
        result.sort((a, b) => (query[1] === 1 ? a - b : b - a));
        continue;
    }

    if (query[1] === 0) {
        result.unshift(query[2]);
    } else if (result.length > 0 && query[1] === result.length) {
        result.push(query[2]);
    } else {
        result = [
            ...result.slice(0, query[1]),
            query[2],
            ...result.slice(query[1]),
        ];
    }
}
console.log(result.length);
console.log(result.length > 0 ? result.join(' ') : '');
