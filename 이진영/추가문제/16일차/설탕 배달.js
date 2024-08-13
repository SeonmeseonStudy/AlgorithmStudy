const KILO1 = 3;
const KILO2 = 5;

const main = () => {
    const input = Number(require('fs').readFileSync('/dev/stdin').toString().trim());

    for (let i = Math.floor(input / KILO2); i >= 0; i--) {
        if ((input - i * KILO2) % KILO1 === 0) {
            console.log(i + (input - i * KILO2) / KILO1)
            return;
        }
    }

    console.log(-1);
}

main();
