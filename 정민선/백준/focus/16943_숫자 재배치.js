const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const [A, B] = input.split(' ');
let Anumbers = A.split('');
let Bnum = Number(B);

function permutation(arr) {
    let result = [];
    let visited = Array(arr.length).fill(false);

    function backtrack(current) {
        if (current.length ===  arr.length) {
            let number = current.join("");
            if (number[0] !== "0") result.push(Number(number));
            return;
        }

        for (let i=0; i<arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtrack([...current, arr[i]]);
            visited[i] = false;
        }
    }
    backtrack([])
    return result
}

let numbers = permutation(Anumbers);
let filterNumbers = numbers.filter(num => num < Bnum);
let answer = Math.max(...filterNumbers, -1);
console.log(answer);