const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [s, t] = input;

function deleteA(string) {
    return string.slice(0, string.length - 1);
}

function deleteBAndReverse(string) {
    let word = Array.from(string.slice(1, string.length));
    word.reverse();
    return word.join("");
}

let answer = 0;
let queue = [t]; 
let visited = new Set();
visited.add(t);

while (queue.length > 0) {
    let current = queue.shift();

    if (current === s) {
        answer = 1; 
        break;
    }
    if (current[current.length - 1] === 'A') {
        let newStr = deleteA(current);
        if (!visited.has(newStr)) {
            visited.add(newStr);
            queue.push(newStr);
        }
    }

    if (current[0] === 'B') {
        let newStr = deleteBAndReverse(current);
        if (!visited.has(newStr)) {
            visited.add(newStr);
            queue.push(newStr);
        }
    }
}

console.log(answer);