const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let T = Number(input.shift());
let result = [];
for (let test=0; test<T; test++){
    let func = input.shift().split('');
    let n = Number(input.shift());
    let numbers = input.shift().slice(1, -1).split(',').map(Number);
    
    let isReverse = false;
    let start = 0, end = n-1;
    let error = false;

    for (let f of func){
        if (f === 'R'){
            isReverse = !isReverse;
            continue;
        }
        if (f === 'D'){
            if (start > end){
                error = true;
                break;
            }
            if (isReverse){
                end--;
            } else {
                start++;
            }
            continue;
        } else {
            error = true;
        }
    }
    if (error) {
        result.push('error')
    } else {
        let final = numbers.slice(start, end+1);
        if (isReverse){
            final.reverse();
        }
        result.push('['+final+']')
    }
}
console.log(result.join('\n'));