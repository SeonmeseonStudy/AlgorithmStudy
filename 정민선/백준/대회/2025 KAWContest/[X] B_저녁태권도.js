// 2040년, KSA는 학생들의 체력 증진을 위해 저녁 태권도를 신설했다.
// 기존에는 매일 오전 7시부터 7시 반까지 아침 태권도를 진행했었는데, 학생들을 분산하기 위해 오후 10시부터 10시 반까지 시간을 마련했다.
// 학생 N명은 M일 동안 매일 아침 태권도와 저녁 태권도 중 하나를 선택해서 참석해야 한다.
// 단, 학교는 i번째 날의 아침 태권도 수업에 A_i명 이상, 저녁 태권도에 B_i명 이상이 참석해야 한다는 조건을 내걸었다.
// 조건을 내걸자 매일 참여해야 한다는 사실에 학생들 사이에서 반발이 심했다. 이를 의식한 KSA는 각 학생에게 종이 카드를 1장씩 지급했다.
// 해당 종이 카드를 이용하면 하루 태권도에 참석하지 않게 된다. 학생들은 태권도 수업을 매우 싫어하기 때문에 반드시 종이 카드를 사용한다.
// 당신은 KSA 졸업생으로서 학생들이 어떻게 출석해야 다같이 무사히 태권도를 수강 완료할 수 있을지 알려주려고 한다.

// 입력
// 첫 번째 줄에 두 개의 정수 N, M이 공백으로 구분되어 주어진다.

// 다음 M개의 줄 중 i번째 줄에 두 개의 정수 A_i, B_i가 공백으로 구분되어 주어진다.

// 출력
// 모든 학생이 조건을 만족하여 태권도를 수강하는 방법이 존재한다면 첫 번째 줄에 YES를 출력하고 다음 N개의 줄 중 i번째 줄에 문자열 S_i를 출력한다.
// S_i는 +, -, X로 구성된 길이 M의 문자열이고, j번째 문자가 +이면 i번째 학생이 j번째 날에 아침 태권도에 참석하고, -이면 저녁 태권도에 참석하며, X이면 결석한다는 뜻이다.
// 모든 학생이 조건을 만족하여 태권도를 수강하는 방법이 존재하지 않는다면 대신 NO를 출력한다.
// 정답이 여러 개 존재한다면 그중 아무거나 출력해도 상관없다.

// 입력
// 5 4
// 2 2
// 2 1
// 1 3
// 3 0

// 출력
// YES
// +-+X
// +X--
// X+-+
// -+X+
// -X-+

const fs = require("fs");
let input = fs
    .readFileSync("./정민선/백준/input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
let conditions = input.slice(1).map((e) => e.split(" ").map(Number));
let attendance = Array.from({ length: N }, () => Array(M).fill("X"));
let morningCount = Array(M).fill(0);
let eveningCount = Array(M).fill(0);

function backtrack(studentIndex) {
    console.log(attendance)
    if (studentIndex === N) {
        for (let i = 0; i < M; i++) {
            if (
                morningCount[i] < conditions[i][0] ||
                eveningCount[i] < conditions[i][1]
            ) {
                return false;
            }
        }
        console.log("YES");
        for (let i = 0; i < N; i++) {
            console.log(attendance[i].join(""));
        }
        return true;
    }

    for (let i = 0; i < M; i++) {
        if (morningCount[i] < conditions[i][0]) {
            attendance[studentIndex][i] = "+";
            morningCount[i]++;
            if (backtrack(studentIndex + 1)) {
                return true;
            }
            attendance[studentIndex][i] = "X";
            morningCount[i]--;
        }

        if (eveningCount[i] < conditions[i][1]) {
            attendance[studentIndex][i] = "-";
            eveningCount[i]++;
            if (backtrack(studentIndex + 1)) {
                return true;
            }
            attendance[studentIndex][i] = "X";
            eveningCount[i]--;
        }

        attendance[studentIndex][i] = "X";
    }

    return false;
}

if (!backtrack(0)) {
    console.log("NO");
}
