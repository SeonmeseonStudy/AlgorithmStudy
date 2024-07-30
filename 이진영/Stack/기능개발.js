function solution(progresses, speeds) {
    const n = progresses.length;
    
    // 걸리는 시간 저장
    let days = progresses.map((val, idx) => Math.ceil((100 - val) / speeds[idx]));
    
    // 처음 기준 세팅
    let ret = [];
    let st = days[0];
    let count = 1;

    // 기준보다 큰 값이 들어오면 count 저장, 초기화 & 기준 새로 저장
    for (let i = 1; i < n; i++) {
        if (days[i] > st){
            ret.push(count);
            st = days[i];
            count = 0;
        }
        count++;
    }
    // 마지막 count 저장
    ret.push(count);
    
    return ret;
}