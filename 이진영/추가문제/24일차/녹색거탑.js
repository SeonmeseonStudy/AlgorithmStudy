const main = () => {
    let input = Number(require('fs').readFileSync('dev/stdin')
        .toString().trim());

    console.log(2 ** input)    
}

main();
