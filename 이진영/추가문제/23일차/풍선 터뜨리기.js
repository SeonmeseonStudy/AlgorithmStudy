const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split("\n").map(i => i.trim());
    
    let balloons = input[1].split(" ").map((v, i) => [i + 1, v]);
    let count = 0;
    let answer = [];
    
    while (balloons.length > 0) {
        while (count !== 0) {
            if (count > 0) {
                count--;
                balloons.push(balloons.shift());
            } else {
                count++;
                balloons.unshift(balloons.pop());
            }
        }

        let cur = balloons.shift();
        count = cur[1] > 0 ? cur[1] - 1 : cur[1];
        answer.push(cur[0]); 
    }

    console.log(answer);
}

main();