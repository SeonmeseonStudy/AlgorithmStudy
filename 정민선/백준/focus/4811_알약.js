const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');

for (let data of input) {
    let pill = Number(data);
    if (pill === 0) break;
    let dp = Array.from({length:(pill+1)}, () => Array(pill+1).fill(0));
    dp[pill][0] = 1;

    for (let i = pill; i >= 0; i--) {
        for (let j = pill; j >= 0; j--) {
            if (i > 0 && j + 1 <= pill) dp[i - 1][j + 1] += dp[i][j]; 
            if (j > 0) dp[i][j - 1] += dp[i][j];
        }
    }
    console.log(dp[0][0])
}
