const input = require('fs').readFileSync('dev/stdin').toString().split("\n");
const N = +input[0];
const Ts = input.slice(1).map(Number);

const answer = [];
let arr = [];

Ts.forEach(T => {
    init();
    dfs(2, T, "1");
    answer.push(arr.join("\n"));
})

console.log(answer.join("\n\n"));

function calc(str) {
    const eq = str.replaceAll(" ", "").match(/(\d+)|\+|\-/g);
    let ret = +eq[0];
    for (let i = 1; i < eq.length; i += 2) {
        if (eq[i] === "-") ret -= +eq[i + 1];
        if (eq[i] === "+") ret += +eq[i + 1];
    }
    return ret;
}

function dfs(cur, t, result) {
    if (cur > t) {
        if (calc(result) === 0) arr.push(result);
        return;
    }
    dfs(cur + 1, t, result + " " + cur);
    dfs(cur + 1, t, result + "+" + cur);
    dfs(cur + 1, t, result + "-" + cur);
}

function init() {
    arr = [];
}