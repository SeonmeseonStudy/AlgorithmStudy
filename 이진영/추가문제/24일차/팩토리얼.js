const main = () => {
    let input = Number(require('fs').readFileSync('dev/stdin')
        .toString().trim());

    let answer = 1;
    for (let i = 1; i <= input; i++) {
        answer *= i;
    }
    console.log(answer);
}

main();