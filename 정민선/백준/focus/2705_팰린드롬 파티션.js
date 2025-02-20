const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split("\n");
const T = Number(input.shift());

let dp = Array(10001).fill(-1);
dp[0] = 1;
dp[1] = 1;
dp[2] = 2;
dp[3] = 2;

for (let data of input) {
    let number = Number(data.trim());
    if (dp[number] !== -1) {
        console.log(dp[number]);
        continue;
    }
    for (let i=4; i<=number; i++) {
        if (i%2 === 0) {
            dp[i] = dp[i-1] + dp[i/2];
        } else{
            dp[i] = dp[i-1];
        }
    }
    console.log(dp[number]);
}
