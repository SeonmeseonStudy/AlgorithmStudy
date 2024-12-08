const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
let n = input.length;
let countA = (input.match(/a/g) || []).length;

if (countA === 0 || countA === n) {
    return console.log(0);
}

let countB = 0; // a의 개수만틈의 배열에서 b가 몇개인지 구하기
for (let i=0; i<countA; i++) {
    if (input[i] === 'b'){
        countB++;
    }
}

let answer = countB;
const string = input+input;

for (let i=1; i<n; i++){ // 배열을 돌면서 b의 개수 세기 그중 가장 작은값이 정답
    if (string[i-1] === 'b') {
        countB--;
    }
    if (string[i+countA-1] === 'b') {
        countB++;
    }

    answer = Math.min(answer, countB);
}

console.log(answer);