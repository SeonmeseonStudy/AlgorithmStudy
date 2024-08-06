from collections import deque
n, m = 0, 0 
def in_range(x, y):
    return 0 <= x < n and 0 <= y < m

def solution(maps):
    global n, m
    answer = -1
    n = len(maps)
    m = len(maps[0])
    
    dxs, dys = [1, 0, -1, 0], [0, -1, 0, 1]
    queue = deque([(0, 0, 1)])
    while queue:
        x, y, d = queue.popleft()
        if x == n-1 and y == m-1:
            answer = d
            break
        
        for dx, dy in zip(dxs, dys):
            nx, ny = x+dx, y+dy
            if in_range(nx, ny) and maps[nx][ny] == 1:
                maps[nx][ny] = 0
                queue.append((nx, ny, d + 1))
        
    return answer