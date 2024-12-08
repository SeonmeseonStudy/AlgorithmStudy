const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input[0]);
let schedule = input.slice(1).map(e => e.split(' ').map(Number));

schedule.sort((a,b) => {
    if (a[1] === b[[1]]) {
        return a[0]-b[0];
    }
    return a[1]-b[1];
});

let count = 0;
let time = 0;

for (let [start, end] of schedule) {
    if (start >= time){
        count++;
        time = end;
    }
}

console.log(count);