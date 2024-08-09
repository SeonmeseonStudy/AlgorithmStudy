const BOARD_SIZE = 8;

const main = () => {
    const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n");
    const [n, m] = input[0].trim().split(" ").map(Number);

    const board = input.slice(1).map(i => i.trim().split("").map(i => {
        if (i === "W") return 1;
        else return 0;
    }))

    let min = 64;

    for (let i = 0; i < n - BOARD_SIZE + 1; i++) {
        for (let j = 0; j < m - BOARD_SIZE + 1; j++) {
            min = Math.min(min, getMinPaint(board.slice(i).map(i => i.slice(j))));
        }
    }
    console.log(min);
}

const getMinPaint = (board) => {
    let temp1 = 1;
    let temp2 = 0;
    let count1 = 0;
    let count2 = 0;

    for (let i = 0; i < BOARD_SIZE; i++) {
        for (let j = 0; j < BOARD_SIZE; j++) {
            if (board[i][j] !== temp1) count1++;
            if (board[i][j] !== temp2) count2++;
            temp1 = 1 - temp1;
            temp2 = 1 - temp2;
        }
        temp1 = 1 - temp1;
        temp2 = 1 - temp2;
    }

    return Math.min(count1, count2);
}

main();

