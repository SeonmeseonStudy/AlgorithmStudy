const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());

function gcd(a, b){
    return b === 0 ? a : gcd(b, a % b); // 최대공약수
}

for (let i=0; i<N; i++){
    let [m, n, x, y] = input.shift().split(' ').map(Number);
    let lcm = (m*n) / gcd(m,n);
    let year = -1;

    for (let i=x; i<=lcm; i+=m){
        if ((i-1)%n + 1 === y){
            year = i;
            break;
        }
    }
    console.log(year);
} 