const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');

for (let data of input) {
    if (data == 0) break;
    let numbers = data.split(' ').map(Number);

    function backtrack(start, array) {
        if (array.length === 6) {
            console.log(array.join(' '));
            return
        }
        for (let i=start; i<=numbers[0]; i++){
            backtrack(i+1, [...array, numbers[i]]);
        }
    }

    backtrack(1, []);
    console.log();
}