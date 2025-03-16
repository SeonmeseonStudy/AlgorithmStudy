// 시간초과
const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split('\n');
let [n, m, q] = input[0].split(' ').map(Number);

let board = Array(n+1).fill(0);

for (let i=1; i<=m; i++) {
    let [pos, weight] = input[i].split(' ').map(Number);
    board[pos] = weight;
}

for (let i=m+1; i<=m+q; i++) {
    let student = Number(input[i]);
    
    let left = 0, right = 0;
    for (let j = 1; j < student; j++) {
        left += board[j];
    }

    for (let j = student; j <= n; j++) {
        right += board[j];
    }
    
    function breakWall(student, pos) {
        if (pos === 'left') {
            console.log(left);
            for(let i=0; i<student; i++) {
                board[i] = 0;
            }
        } else {
            console.log(right);
            for(let i=student; i<=n; i++) {
                board[i] = 0;
            }
        }
    }

    if (left == right) {
        if (student-1 >= n - student) {
            breakWall(student, 'left');
        } else {
            breakWall(student, "right");
        }
    } else if (left < right) {
        breakWall(student, 'left');
    } else {
        breakWall(student, "right");
    }
}