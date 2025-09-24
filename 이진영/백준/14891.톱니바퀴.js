const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const wheels = input.slice(0, 4).map(v => v.split("").map(Number));
const k = +input[4].trim();
const rotates = input.slice(5).map(v => v.split(" ").map(Number));

const twelvePointer = [0, 0, 0, 0];

const rotate = (wheelNum, direction) => {
    if (direction === 1) {
        twelvePointer[wheelNum] = twelvePointer[wheelNum] === 0 ? 7 : twelvePointer[wheelNum] - 1
    } else if (direction === -1) {
        twelvePointer[wheelNum] = twelvePointer[wheelNum] === 7 ? 0 : twelvePointer[wheelNum] + 1
    }
}

const calculateScore = () => {
    return wheels.reduce((p, n, idx) => p + n[twelvePointer[idx]] * (2 ** idx), 0);
}

const rotateAll = (number, direction, passed) => {
    const left = number === 0 ? null : number - 1;
    const right = number === 3 ? null : number + 1;

    const wheel = wheels[number];
    const twelve = twelvePointer[number];

    if (left !== null && !passed.includes(left)) {
        const leftWheel = wheels[left];
        const leftTwelve = twelvePointer[left];
        if (leftWheel[leftTwelve > 5 ? leftTwelve - 6 : leftTwelve + 2] !== wheel[twelve < 2 ? twelve + 6 : twelve - 2]) {
            rotateAll(left, direction * -1, [...passed, number]);
        }
    }

    if (right !== null && !passed.includes(right)) {
        const rightWheel = wheels[right];
        const rightTwelve = twelvePointer[right];
        if (wheel[twelve > 5 ? twelve - 6 : twelve + 2] !== rightWheel[rightTwelve < 2 ? rightTwelve + 6 : rightTwelve - 2]) {
            rotateAll(right, direction * -1, [...passed, number]);
        }
    }

    rotate(number, direction);
}

rotates.forEach(([num, dir]) => {
    rotateAll(num - 1, dir, []);
})

console.log(calculateScore());