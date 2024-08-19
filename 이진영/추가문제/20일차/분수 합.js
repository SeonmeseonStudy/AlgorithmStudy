const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").map(i => i.trim());

    const [a1, b1] = input[0].split(" ").map(Number);
    const [a2, b2] = input[1].split(" ").map(Number);

    let a3 = a1 * b2 + a2 * b1;
    let b3 = b1 * b2;

    for (let i = b3; i > 1; i--) {
        if (a3 % i === 0 && b3 % i === 0) {
            a3 /= i;
            b3 /= i;
            break;
        }
    }

    console.log(a3 + " " + b3);
}
main();