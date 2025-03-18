const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim();
let num = Number(input);

let startYear = 2024;
let startMonth = 8;

let cups = [[startYear, startMonth]];
for (let i=0; i<num; i++) {
    let year = startYear;
    let month = startMonth+7;

    if (month > 12) {
        year++;
        month -= 12;
    }

    cups.push([year, month]);
    startYear = year;
    startMonth = month;
}

console.log(cups[num-1].join(' '));