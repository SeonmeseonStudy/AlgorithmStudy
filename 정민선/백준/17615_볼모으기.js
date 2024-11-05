const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
let n = Number(input[0]);

let balls = input[1].split("");
let red = balls.filter(ball => ball === 'R').length;
let blue = n-red;
let answer = Math.min(red, blue);

function leftCheck(array, color) {
    let count = 0;
    for (let i=0; i<n; i++){
        if (array[i] != color) {
            break
        }
        count += 1
    }
    return count
};
function rightCheck(array, color) {
    let count = 0;
    for (let i=n-1; i>=0; i--){
        if (array[i] != color) {
            break
        }
        count += 1
    }
    return count
};

let first = balls[0];
let count = leftCheck(balls, first);
if (first === 'R') {
    answer = Math.min(answer, red-count);
} else {
    answer = Math.min(answer, blue-count);
}

let last = balls[n-1];
count = rightCheck(balls, last);
if (last === 'R') {
    answer = Math.min(answer, red-count);
} else {
    answer = Math.min(answer, blue-count);
}
console.log(answer)