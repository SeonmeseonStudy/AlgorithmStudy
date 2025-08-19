const reader = require('readline').Interface({
    input: require('fs').createReadStream('dev/stdin'),
    output: undefined
})

let n, m;
const map = new Map();
let indegree = [];

reader.on('line', line => {
    if (!n && !m) {
        [n, m] = line.trim().split(" ").map(Number);
        indegree = Array(n + 1).fill(0);
        return;
    }

    const [a, b] = line.trim().split(" ").map(Number); // a < b

    if (!map.has(a)) map.set(a, new Set());
    map.get(a).add(b);
    indegree[b]++;
})

reader.on('close', () => {
    console.log(dfs().join(" "))
})

const dfs = () => {
  const stack = [];
  const result = [];
  for (let i = 1; i <= n; i++) {
    if (!indegree[i]) stack.push(i);
  }
  while (stack.length) {
    const cur = stack.pop();
    result.push(cur);
    if (map.has(cur)) {
        map.get(cur).forEach((nextNode) => {
        indegree[nextNode] -= 1;
        if (!indegree[nextNode]) stack.push(nextNode);
    }); 
    }
  }
  return result;
};