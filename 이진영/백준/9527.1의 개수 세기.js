const [a, b] = require("fs").readFileSync('dev/stdin').toString().trim().split(" ").map(BigInt);

let d = Array(55).fill(0n);

function go(x, i = 54n) {
  let ans = x & 1n;
  for (; i > 0n; i--) {
    if (x & (1n << i)) {
      ans += d[Number(i - 1n)] + (x - (1n << i) + 1n);
      x -= 1n << i;
    }
  }
  return ans;
}

d[0] = 1n;
for (let i = 1; i < 55; i++) {
  d[i] = d[i - 1] * 2n + (1n << BigInt(i));
}

console.log((go(b) - go(a - 1n)).toString());

// https://degurii.tistory.com/158