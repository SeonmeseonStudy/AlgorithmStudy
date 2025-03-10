const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);

function calculate(array) {
    let sum = 0;
    for (let i=0; i<N-1; i++) {
        sum += Math.abs(array[i] - array[i+1])
    }
    return sum;
}

let maxAnswer = 0;


function getPermutations(array, select) {
    let result = []
    if (select === 1) {
        return array.map((v) => [v])
    }

    array.forEach((value, index, currentArray) => {
        const rest = [...currentArray.slice(0, index), ...currentArray.slice(index+1)];
        const permutations = getPermutations(rest, select-1);
        const attached = permutations.map((v) => [value, ...v]);
        result.push(...attached);
    });
    return result
}

let resultPermutations = getPermutations(numbers, N);
resultPermutations.forEach((e) => {
    maxAnswer = Math.max(maxAnswer, calculate(e));
})

console.log(maxAnswer)