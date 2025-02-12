const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let eggs = input.map(e => e.split(' ').map(Number));

// 내구도가 HP 무게가 공격력
let answer = 0;
function backtracking(number) {
    if (number === N) {
        let count = 0;
        for (let i=0; i<N; i++) {
            if (eggs[i][0] <= 0){
                count++;
            }
        }
        answer = Math.max(answer, count);
        return
    }

    if (eggs[number][0] <= 0) {
        return backtracking(number+1)
    }

    let broken = true;
    for (let i=0; i<N; i++) {
        if (i === number) continue;
        if (eggs[i][0] > 0){
            broken = false;
            break;
        }
    }
    if (broken) {
        answer = Math.max(answer, N-1);
        return
    }

    for (let i=0; i<N; i++) {
        if (i === number || eggs[i][0] <= 0) continue;
        eggs[number][0] -= eggs[i][1];
        eggs[i][0] -= eggs[number][1];
        backtracking(number+1)
        eggs[number][0] += eggs[i][1];
        eggs[i][0] += eggs[number][1];
    }
}
backtracking(0);
console.log(answer);