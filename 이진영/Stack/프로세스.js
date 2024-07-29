function solution(priorities, location) {
    let map = new Map();
    let q = [];
    let count = 0;
    
    // 인덱스 - 우선 순위 map
    for (let i = 0; i < priorities.length; i++) {
        q.push(i);
        map.set(i, priorities[i]);
    }
    
    while (q.length > 0) {
        // 제일 높은 우선 순위 체크
        let max = Math.max(...q.map(i => priorities[i]));
        
        // 제일 높지 않으면 뒤로 보냄 => 맨 앞에 제일 높은 우선순위의 인덱스 위치
        while (priorities[q[0]] !== max) {
            q.push(q.shift());
        }

        // count 증가, 맨 앞 인덱스 끝내기
        count++;
        if (q.shift() === location) return count;
    }
}