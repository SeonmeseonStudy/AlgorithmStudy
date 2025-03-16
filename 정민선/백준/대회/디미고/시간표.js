const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split('\n');
let [n, m, a, b] = input[0].split(' ').map(Number);

let schedule = input[1].split(' ').map(Number); 
let favorite = new Set(input[2].split(' ').map(Number));
let unfavorite = new Set(input[3].split(' ').map(Number)); 

let answer = 0;
let fc = 0, unfc = 0;

for (let s of schedule) {
    if (!favorite.has(s) && !unfavorite.has(s)) {
        if (fc > 2) {
            answer += fc;
        }
        if (unfc > 2) {
            answer -= unfc;
        }
        
        fc = 0;
        unfc = 0;
    }

    if (favorite.has(s)) {
        fc++;
    }
    else {
        if (fc > 2) answer += fc;
        fc = 0;
    }

    if (unfavorite.has(s)) {
        unfc++;
    } else {
        if (unfc > 2) answer -= unfc;
        unfc = 0;
    }
}

if (fc > 2) {
    answer += fc;
}
if (unfc > 2) {
    answer -= unfc;
}

console.log(answer);