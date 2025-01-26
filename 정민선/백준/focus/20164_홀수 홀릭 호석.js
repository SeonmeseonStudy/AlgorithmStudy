const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const number = Number(input);

function countOdd(num){
    return num.toString().split('').filter(e => parseInt(e)%2 === 1).length;
}

function dfs(num, odd) {
    const current = countOdd(num);
    odd += current;

    if (num.toString().length === 1) {
        return [odd, odd];
    }

    let minResult = Infinity;
    let maxResult = -Infinity;

    if (num.toString().length === 2) {
        const [a, b] = num.toString().split('').map(Number);
        const newNum = a+b;
        const result = dfs(newNum, odd);
        minResult = Math.min(minResult, result[0]);
        maxResult = Math.max(maxResult, result[1]);
    }

    if (num.toString().length > 2) {
        const string = num.toString();
        const length = string.length;

        for (let i=1; i<length; i++) {
            for (let j=i+1; j<length; j++){
                const a = parseInt(string.slice(0, i));
                const b = parseInt(string.slice(i, j));
                const c = parseInt(string.slice(j));
                const newNum = a+b+c;

                const result = dfs(newNum, odd);
                minResult = Math.min(minResult, result[0]);
                maxResult = Math.max(maxResult, result[1]);
            }
        }

    }
    return [minResult, maxResult];
}

let answer = dfs(number, 0);
console.log(answer.join(' '))