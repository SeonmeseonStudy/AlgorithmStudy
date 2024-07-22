function solution(numbers) {
    // 모든 수를 문자열로 변환하여 더하고, 그 값이 더 클 수록 앞으로 정렬
    let ret = numbers.map(i => i.toString()).sort((a, b) => (b + a) - (a + b)).join("");
    return ret[0] === '0' ? '0' : ret;
}