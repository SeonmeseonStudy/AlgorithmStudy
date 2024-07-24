// 특정 시간 안에 처리할 수 있는 사람 수
const getPerson = (times, time) => {
    let ret = 0;
    for (let t of times) {
        ret += Math.floor(time / t);
    }
    return ret;
}

function solution(n, times) {
    let low = 1;
    let high = times[times.length - 1] * n; // 중요! 왜 이렇게 설정해야 답이 나오는지 모르겠음...
    
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        let person = getPerson(times, mid);
        
        if (person < n) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    return low;
}