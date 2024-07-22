function solution(k, dungeons) {    
    let max = 0;
    let visited = Array(dungeons.length).fill(false);
    
    const getCount = (k, dungeons, visited, count) => {
        if (visited.every(x => x)) {
            max = Math.max(max, count);
            return;
        }
        
        for (let i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            getCount(k, dungeons, visited, count);
            if (k >= dungeons[i][0])
                getCount(k - dungeons[i][1], dungeons, visited, count + 1);
            visited[i] = false;
        }
    }
    
    getCount(k, dungeons, visited, 0);
    return max;
}