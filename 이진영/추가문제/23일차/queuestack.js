const main = () => {
    let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

    const a = input[1].split(" ");
    let b = input[2].split(" ")
    const c = input[4].split(" ")
    let answer = [];

    let q = b.filter((_, i) => a[i] === '0');

    let front = 0;
    let back = q.length;

    for (let inp of c) {
        q[--front] = inp;
        answer.push(q[back - 1]);
        back--;
    }

    console.log(answer.join(" "));
}

main();
