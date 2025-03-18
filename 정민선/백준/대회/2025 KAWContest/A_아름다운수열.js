// 이 대회의 운영진 중 한 명인 KSA 학생은 슬슬 소수가 좋아져서 아래 조건들을 모두 만족하는 수열을 길이가 N인 아름다운 수열이라고 하기로 했다.
// 수열은 길이가N인 순열이다. 즉,1 이상N 이하의 정수들이 정확히 한 번씩 등장한다.거리가 소수인 두 다른 원소 사이의 차는 소수여야 한다.
// i번째 원소와 j번째 원소 사이의 거리는|j-i|이다.

// 입력
// 입력은 하나 이상의 테스트 케이스로 이루어져 있다. 첫 번째 줄에 테스트 케이스의 개수T가 주어진다. 
// 각 테스트 케이스는 아래와 같이 주어진다.
// 각 테스트 케이스는 한 줄로 이루어져 있고, 정수N이 주어진다.

// 출력
// 각 테스트 케이스에 대해, 길이가 N인 아름다운 수열이 존재한다면 첫 번째 줄에 YES를 출력하고 두 번째 줄에 그 원소들을 공백으로 구분하여 출력한다. 
// 길이가 N인 아름다운 수열이 존재하지 않는다면 대신 NO를 출력한다.
// 정답이 여러 개 존재한다면 그중 아무거나 출력해도 상관없다.

// 입력
// 2
// 5
// 7

// 출력
// YES
// 2 1 5 4 3
// YES
// 6 2 3 4 5 1 7

const fs = require("fs");
let input = fs.readFileSync("./정민선/백준/input.txt").toString().trim().split("\n");
const T = Number(input.shift());

function isPrime(n) {
    if (n < 2) return false;
    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) return false;
    }
    return true;
}

const primeArray = Array(301).fill(false);
for (let i = 2; i < 301; i++) {
    if (isPrime(i)) primeArray[i] = true;
}

for (let data of input) {
    let num = Number(data);
    let visited = Array(num + 1).fill(false);
    let array = [];

    function backtracking() {
        if (array.length === num) {
            console.log("YES");
            console.log(array.join(" "));
            return true;
        }

        for (let i = 1; i <= num; i++) {
            if (!visited[i]) {
                let check = true;
                if (array.length > 0) {
                    for (let j=0; j<array.length; j++) {
                        let indexDiff = Math.abs((array.length+1) - (j+1));
                        let valueDiff = Math.abs(i - array[j]);
                        if (primeArray[indexDiff] && !primeArray[valueDiff]) {
                            check = false;
                            break
                        }
                    }
                }
                if (!check) continue;

                array.push(i);
                visited[i] = true;
                if (backtracking()) return true;
                array.pop();
                visited[i] = false;
            }
        }
        return false;
    }
    if (!backtracking(num)) {
        console.log("NO");
    }
}