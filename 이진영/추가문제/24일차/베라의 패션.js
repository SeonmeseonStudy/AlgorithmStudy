const main = () => {
    let input = Number(require('fs').readFileSync('dev/stdin')
        .toString().trim());

    console.log(input * (input - 1))    
}

main();
