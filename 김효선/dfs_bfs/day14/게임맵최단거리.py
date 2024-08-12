# 코드 해설 봐가면서 풀어서 다시 풀어봐야함듯...
from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    # 방향
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    # 큐(x,y,거리)
    queue = deque([(0, 0, 1)]) 
    
    # 중복 방지
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True
    
    while queue:
        x, y, dist = queue.popleft()
        
        # 도착하면 거리 반환
        if x == n - 1 and y == m - 1:
            return dist
        
        # 4방향
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            # 맵 벗어남x + 벽x + 방문x 일 경우
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, dist + 1))

    return -1
