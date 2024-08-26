let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

let nums = input.map(Number);

nums.forEach(num => {
    const size = 3 ** num;
    let arr = new Array(size).fill(true);
    let subSize = size;

    while (subSize > 1) {
        subSize /= 3;
        
        for (let i = subSize; i < size; i += subSize * 2) {
            for (let j = i; j < i + subSize; j++) {
                arr[j] = false;
            }
        }
    }

    let answer = "";
    arr.forEach(i => {
        if (i) answer += "-";
        else answer += " ";
    })
    console.log(answer);
})

