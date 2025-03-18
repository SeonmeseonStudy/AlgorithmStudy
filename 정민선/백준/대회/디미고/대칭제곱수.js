const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split("\n");
let n = input.shift();

for (let data of input) {
    let num = Number(data);
    let sqrt = Math.sqrt(num);

    if (Math.floor(sqrt) !== sqrt) {
        console.log("NO");
        continue;
    }
    
    let reversedNum = Number(data.split('').reverse().join(''));
    let sqrt2 = Math.sqrt(reversedNum);

    if (Math.floor(sqrt2) === sqrt2) {
        console.log("YES");
    } else {
        console.log("NO");
    }
    
}