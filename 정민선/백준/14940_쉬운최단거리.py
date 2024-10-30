n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]

def inrange(x, y):
    return 0 <= x < n and 0 <= y < m

from collections import deque

tx, ty = 0, 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            tx, ty = i, j
            break

queue = deque()
def push(x, y, value):
    visited[x][y] = True
    board[x][y] = value
    queue.append((x, y))

push(tx, ty, 0)
def bfs():
    dxs, dys = [1, 0, -1, 0], [0, 1, 0, -1]
    
    while queue:
        x, y = queue.popleft()
        
        for dx, dy in zip(dxs, dys):
            nx, ny = dx+x, dy+y
            if inrange(nx, ny) and not visited[nx][ny] and board[nx][ny] != 0:
                push(nx, ny, board[x][y]+1)
                
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and board[i][j] == 1 :
                board[i][j] = -1

bfs()
for b in board:
    print(" ".join(map(str, b)))