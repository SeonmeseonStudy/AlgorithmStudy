const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const n = Number(input[0]);
    const nums = input.slice(1).map(Number).sort((a, b) => a - b);

    console.log(Math.round(nums.reduce((p, n) => p + n, 0) / n) + 0);
    console.log(nums[Math.floor(n / 2)]);

    let maxFreqNums = [];
    let maxFreq = 0;
    
    for (let i = 0; i <  n; i++) {
        let num = nums[i];
        let lastIndex = nums.lastIndexOf(num);

        let freq = lastIndex - i + 1;

        if (freq > maxFreq) {
            maxFreqNums = [];
            maxFreq = freq;
        }

        if (freq === maxFreq) {
            maxFreqNums.push(num);
        }

        i = lastIndex;
    }

    maxFreqNums.length > 1 ? console.log(maxFreqNums[1]) : console.log(maxFreqNums[0]);

    console.log(nums[n - 1] - nums[0]);
}

main();