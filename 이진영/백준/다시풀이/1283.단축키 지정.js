const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");
const n = +input[0];
const words = input.slice(1).map(v => v.trim());

let answer = [];
let set = new Set();

for (const word of words) {
    const parts = word.split(" ");
    let flag = false;

    for (let i = 0; i < parts.length; i++) {
        // 빈 문자열 체크 추가
        if (parts[i].length === 0) continue;
        
        const newKey = parts[i][0].toLowerCase(); // 대소문자 구분 없이 처리

        if (!set.has(newKey)) {
            set.add(newKey);
            parts[i] = convertKey(parts[i], 0);
            answer.push(parts.join(" "));
            flag = true;
            break;
        }
    }

    if (!flag) {
       for (let i = 0; i < word.length; i++) {
            const newKey = word[i].toLowerCase(); // 대소문자 구분 없이 처리
            if (newKey === " ") continue;

            if (!set.has(newKey)) {
                set.add(newKey);
                answer.push(convertKey(word, i));
                flag = true;
                break;
            }
       }
    }

    if (!flag) {
        answer.push(word);
    }
}

console.log(answer.join("\n"));

function convertKey(part, idx) {
    return part.split("").map((v, i) => i === idx ? `[${v}]` : v).join("");
}