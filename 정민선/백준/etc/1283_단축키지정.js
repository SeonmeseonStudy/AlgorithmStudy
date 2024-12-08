const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
let N = Number(input[0]);
let options = input.slice(1);
let alphabet = new Set();

function shortcutKeyFirst(option) {
    let words = option.split(" ");
    for (let i=0; i<words.length; i++){
        let char = words[i][0].toLowerCase();
        if (char === "" || char === " ") {
            continue;
        }
        if (!alphabet.has(char)) {
            alphabet.add(char);
            words[i] = words[i].replace(words[i][0], `[${words[i][0]}]`);
            return words.join(" ");
        }
    }
    return null;
}

function shortcutKeySecond(option) {
    for (let i=0; i<option.length; i++){
        let char = option[i].toLowerCase();
        if (char === "" || char === " ") {
            continue;
        }
        if (!alphabet.has(char)) {
            alphabet.add(char);
            return option.replace(option[i], `[${option[i]}]`);
        }
    }
    return null;
}

for (let i=0; i<options.length; i++){
    let result = shortcutKeyFirst(options[i]);

    if (!result) {
        result = shortcutKeySecond(options[i]);
    }
    
    options[i] = result || options[i];
}

options.forEach(option => console.log(option));