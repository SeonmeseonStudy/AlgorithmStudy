const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const [N, M] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split(' ').map(Number));

function getchickenStreet(houses, selectChickens) {
    let total = 0;
    for (let [r, c] of houses) {
        let minDistance = Infinity;
        for (let [r2, c2] of selectChickens) {
            let distance = Math.abs(r-r2) + Math.abs(c-c2);
            minDistance = Math.min(distance, minDistance);
        }
        total += minDistance;
    }
    return total;
}

function getCombinations(arr, selectNum) {
    if (selectNum === 0) return [[]];
    if (arr.length === 0) return [];

    const [first, ...rest] = arr;
    const withfirst = getCombinations(rest, selectNum-1).map(e => [first, ...e]);
    const withoutfirst = getCombinations(rest, selectNum);
    return [...withfirst, ...withoutfirst];
}

let chickens = [];
let house = [];
for (let i=0; i<N; i++) {
    for (let j=0; j<N; j++) {
        if (board[i][j] === 1) {
            house.push([i, j]);
        }
        if (board[i][j] === 2) {
            chickens.push([i, j])
        }
    }
}

let combinationChickens = getCombinations(chickens, M);
let answer = Infinity

for (let select of combinationChickens) {
    answer = Math.min(answer, getchickenStreet(house, select));
}

console.log(answer);