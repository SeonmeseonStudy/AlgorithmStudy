function solution(brown, yellow) {
    let sum = brown + yellow;
    
    for (let i = 3; i <= sum / 3; i++) {
        // i는 세로로 정의
        if (sum % i === 0) {
            let j = sum / i; // 가로
            
            if (2 * i + 2 * j - 4 === brown) return [j, i]
        }
    }
    return [-1, -1]
}