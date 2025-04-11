var reader = require('readline').Interface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
})

var T;
var answers = [];

reader.on('line', function (line) {
    if (T === undefined) {
        T = +line.trim();
    } else {
        const [a, b] = line.trim().split(" ").map(Number);
        answers.push(sol(a, b));
    }
})

reader.on('close', function () {
    console.log(answers.join('\n'));
});

function sol(x, y) {
    var dist = y - x;
    var val = 2;
    while (val * val <= dist) {
        val++;
    }
    val--;
    
    var cost = 2 * val - 1;
    var rest = dist - val * val;

    while (rest > 0) {
        cost += Math.floor(rest / val);
        rest %= val;
        val--;
    }

    return cost;
}