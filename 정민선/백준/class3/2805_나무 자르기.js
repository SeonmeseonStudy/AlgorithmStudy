const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let [N, M] = input.shift().split(' ').map(Number);
let numbers = input.shift().split(' ').map(Number);
let result = 0;
let left = 0, right = Math.max(...numbers);

while(left <= right){
    let mid = Math.floor((left+right)/2);
    let sum = 0;
    for (let num of numbers) {
        sum += Math.max(0, num - mid);
    }
    if (sum >= M){
        result = mid;
        left = mid+1;
    } else {
        right = mid-1;
    }
}
console.log(result);