const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input[0]);
let numbers = input[1].split(' ').map(Number);

let new_numbers = [...new Set(numbers)].sort((a,b) => a-b);
let numbers_map = new Map();
new_numbers.forEach((value, index) => {
    numbers_map.set(value, index);
})

let result = [];
for (let n of numbers){
    result.push(numbers_map.get(n));
}
console.log(result.join(' '));