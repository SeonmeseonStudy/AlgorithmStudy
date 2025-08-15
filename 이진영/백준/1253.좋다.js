const input = require('fs').readFileSync('dev/stdin').toString().split("\n");
const n = +input[0];
const arr = input[1].trim().split(" ").map(Number).sort((a, b) => a - b);

let answer = 0;
 
arr.forEach((v, idx) => {
  let start = 0, end = n - 1;
 
  while (start < end) {
    if(arr[start] + arr[end] === v) {
      if(start !== idx && end !== idx){
        answer++;
        break;
      }
      if(start === idx) start++;
      if(end === idx) end--;
      
    } else if(arr[start] + arr[end] > v) end--;
    else start++;
  }
});

console.log(answer);