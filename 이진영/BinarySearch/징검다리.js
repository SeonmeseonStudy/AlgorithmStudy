function solution(distance, rocks, n) {
    // 검색 풀이
    rocks=[...rocks.sort((a,b)=>a-b),distance];
    
    const calculateDist = (k) => {
        // 바위 간의 거리가 k 안에 들어오게 하기 위해서
        // 제거해야하는 바위 개수가 n을 넘는지 확인
        let startDist = 0
        let cnt = n
        for(let i = 0 ; i < rocks.length;i++){
            const curDist = rocks[i]-startDist
            if(curDist < k) cnt--
            else startDist = rocks[i]
        }
        
        if(cnt<0) return false
        return true
    }
    
    
    
    let left = 0;
    let right = distance
    while(left<=right){
        const mid = ~~((left+right)/2)
        if(calculateDist(mid)) left = mid+1
        else right = mid -1
    }
    
    return right
}