function solution(n, vertex) {
    // 연결 관계를 map으로 생성 -> 2차원 배열로 할 경우 메모리 터짐
    let map = new Map();
    for (let v of vertex) {
        if (!map.has(v[0])) map.set(v[0], []);
        if (!map.has(v[1])) map.set(v[1], []);
        
        map.get(v[0]).push(v[1]);
        map.get(v[1]).push(v[0]);
    }
    
    // 1번부터 시작하여 최소 경로 길이 구하기
    let minDist = Array(n + 1).fill(-1);
    minDist[1] = 0;
    let q = [1];
    
    while (q.length > 0) {
        let num = q.shift();
        let dist = minDist[num];
        
        for (let n of map.get(num)) {
            if (minDist[n] === -1) {
                    q.push(n);
                    minDist[n] = minDist[num] + 1;
                } else {
                    minDist[n] = Math.min(minDist[n], minDist[num] + 1);
                }
        }
    }
    
    // 최댓값을 갖는 노드 개수 구하기
    let count = 0;
    let max = 0;
    for (let i = 1; i <= n; i++) {
        if (minDist[i] > max) {
            max = minDist[i];
            count = 1;
        } else if (minDist[i] === max) { 
            count++;
        }
    }
    
    return count;
}