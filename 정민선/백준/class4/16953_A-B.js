const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const [A, B] = input.shift().split(' ').map(Number);

let queue = [];
queue.push([A, 1]);

while (queue.length > 0) {
    let [number, count] = queue.shift();
    if (number === B) {
        console.log(count);
        return
    }

    let nextNumber1 = number*2;
    let nextNumber2 = number*10+1;

    if (nextNumber1 <= B) {
        queue.push([nextNumber1, count + 1]);
    }

    if (nextNumber2 <= B) {
        queue.push([nextNumber2, count + 1]);
    }
}

console.log(-1);