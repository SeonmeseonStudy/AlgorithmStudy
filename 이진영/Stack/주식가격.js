function solution(prices) {
    let l = prices.length;
    let answer = Array(l).fill(0);
    let s = [];
    
    for (let i = 0; i < l; i++) {
        while (s.length > 0 && prices[i] < s[s.length - 1][1]) {
            let pop = s.pop();
            answer[pop[0]] = i - pop[0];
        }
        s.push([i, prices[i]]);
    }
    
    while (s.length > 0) {
        let pop = s.pop();
        answer[pop[0]] = l - 1 - pop[0];
    }
    
    return answer;
}