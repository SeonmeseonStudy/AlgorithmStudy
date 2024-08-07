from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    q = deque([(0, 0, 1)])

    visit = []
    for i in range(n):
        visit.append([False] * m)
    visit[0][0] = True
    
    while q:
        x, y, distance = q.popleft()
        
        if x == n - 1 and y == m - 1:
            return distance
        
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and not visit[nx][ny] and maps[nx][ny] == 1:
                q.append((nx, ny, distance + 1))
                visit[nx][ny] = True
    
    return -1
