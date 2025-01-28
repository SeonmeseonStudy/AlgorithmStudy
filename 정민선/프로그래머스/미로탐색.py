from collections import deque

n,m = map(int, input().split())
board = [list(map(int, input())) for _ in range(n)]

def bfs(board, start, visited):
    queue = deque([(start, 1)]) # 문제 예시보니까 자기 자신부터 거리로 세니까 1로 시작
    visited[start[0]][start[1]] = True
    distance = 0
    
    dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    
    while queue:
        (x, y), distance = queue.popleft()
        for dx, dy in dirs: # 상하좌우 탐색하며 길인 곳으로 가기
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and board[nx][ny] == 1: # 보드 안이고, 방문하지 않았고, 길인 곳만
                if nx == n-1 and ny == m-1: # 도착하면 끝
                    return distance + 1
                
                queue.append(((nx, ny), distance+1)) # 도착 안했으면 큐에 현재 위치 넣으면서 거리 1씩 증가
                visited[nx][ny] = True # 방문했다는 표시
    return -1

visited = [[False] * m for _ in range(n)]
start = (0, 0)
result = bfs(board, start, visited)
print(result)
    