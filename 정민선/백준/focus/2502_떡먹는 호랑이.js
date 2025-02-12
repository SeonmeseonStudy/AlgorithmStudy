const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const [Day, total] = input.split(' ').map(Number);

let Fibo = Array(Day+1).fill(0);
Fibo[0] = 0;
Fibo[1] = 1;
for (let i=2; i<Day; i++) {
    Fibo[i] = Fibo[i-1] + Fibo[i-2];
}

const Fibo2 = Fibo[Day-2];
const Fibo1 = Fibo[Day-1];

for (let i=1; i<total; i++) {
    if ((total - i * Fibo2 ) % Fibo1 === 0) {
        console.log(i);
        console.log((total - i * Fibo2 ) / Fibo1)
        break
    }
}