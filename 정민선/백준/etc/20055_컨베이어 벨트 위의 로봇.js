const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [n, k] = input[0].split(' ').map(Number);
let belt = input[1].split(' ').map(Number);
let [pointLeft, pointRight] = [0, n-1];
let round = 0;
let robots = Array(n*2).fill(false);
let count = belt.filter(e => 0 === e).length;

function moveBelt() {
    pointLeft = (pointLeft - 1 + 2 * n) % (2 * n);
    pointRight = (pointRight - 1 + 2 * n) % (2 * n);
    if (robots[pointRight]){
        robots[pointRight] = false;
    }
}

function moveRobots() {
    for (let i=n-2; i >= 0; i--){
        let index = (pointLeft+i) % (2 * n);
        let next = (index+1) % (2 * n);
        if (robots[index] && !robots[next] && belt[next] > 0){
            robots[next] = true;
            robots[index] = false;
            belt[next]--;
            if (belt[next] === 0) count++;
        }
    }
    if (robots[pointRight]){
        robots[pointRight] = false;
    }
}

function setRobot(){
    if (belt[pointLeft] > 0 && !robots[pointLeft]) {
        robots[pointLeft] = true;
        belt[pointLeft]--;
        if (belt[pointLeft] === 0) count++;
    }
}

while (count < k) {
    moveBelt();
    moveRobots();
    setRobot();
    round++;
}
console.log(round);