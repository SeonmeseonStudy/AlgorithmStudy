const main = () => {
    const input = Number(require('fs').readFileSync('/dev/stdin').toString().trim());
    let k = 666;
    let n = 1;

    while (n !== input) {
        k++;
        if (k.toString().includes("666")) n++;
    }

    console.log(k);
}

main();