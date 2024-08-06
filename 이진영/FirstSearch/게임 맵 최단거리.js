const dr = [1, 0, -1, 0];
const dc = [0, 1, 0, -1];

function solution(maps) {
    const n = maps.length;
    const m = maps[0].length;
    let visited = Array.from(Array(n), () => Array(m).fill(false));
    let q = [[0, 0, 1]] // [r, c, count]
    visited[0][0] = true;
    
    const inRange = (r, c) => {
        if (r >= 0 && r < n && c >= 0 && c < m) return true;
        return false;
    }
    
    while (q.length > 0) {
        let [r, c, count] = q.shift();
        
        if (r === n - 1 && c === m - 1) return count;
        
        for (let i = 0; i < 4; i++) {
            const nr = r + dr[i];
            const nc = c + dc[i];
            if (inRange(nr, nc) && maps[nr][nc] && !visited[nr][nc]) {
                q.push([nr, nc, count + 1]);
                visited[nr][nc] = true;
            }
        }
    }
    
    return -1;
}