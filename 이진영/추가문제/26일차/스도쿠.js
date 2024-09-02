let sudoku = require('fs').readFileSync('dev/stdin')
.toString().trim().split("\n").map(i => i.split(" ").map(Number));
const LENGTH = 9;
const AREA_LENGTH = LENGTH/3;

const check = (r, c, num) => {
    // row, column check
    for (let i = 0; i < LENGTH; i++) {
        if (sudoku[i][c] === num || sudoku[r][i] === num) return false;
    } 
    // area check
    const startR = Math.floor(r/AREA_LENGTH);
    const startC = Math.floor(c/AREA_LENGTH);

    for (let i = 0; i < AREA_LENGTH; i++) {
        for (let j = 0; j < AREA_LENGTH; j++) {
            if (sudoku[startR * AREA_LENGTH + i][startC * AREA_LENGTH + j]
                 === num)
                 return false;
        }
    }

    return true;
}

const print = () => {
    console.log(sudoku.map(i => i.join(" ")).join("\n"));
}

const find = (n) => {
    if (n === blank.length) {
        print();
        process.exit(0)
        
    }

    for (let num = 1; num < 10; num++) {
        const r = blank[n][0];
        const c = blank[n][1];

        if (check(r, c, num)) {
            sudoku[r][c] = num;
            find(n + 1);
            sudoku[r][c] = 0
        }
    }
}

let blank = [];
for (let i = 0; i < LENGTH; i++) {
    for (let j = 0; j < LENGTH; j++) {
        if (sudoku[i][j] === 0) {
            blank.push([i, j]);
        }
    }
}

find(0);