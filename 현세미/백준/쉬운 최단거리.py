#백준 - 14940 쉬운 최단거리
from collections import deque
import sys
input = sys.stdin.readline

direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

n, m = map(int, input().split())
arr = [list(input().split()) for _ in range(n)]

visited = [[False] * m for _ in range(n)]
ans = [[-1] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if arr[i][j] == "2":
            visited[i][j] = True
            q = deque([(i, j)])
            ans[i][j] = 0
            break
    else:
        continue
    break

while q:
    x, y = q.popleft()
    current_distance = ans[x][y]

    for dx, dy in direction:
        nx = x + dx
        ny = y + dy

        # 안에 있는지, 방문여부, 1인지 체크
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and arr[nx][ny] == "1":
            visited[nx][ny] = True
            ans[nx][ny] = current_distance + 1
            q.append((nx, ny))

for i in range(n):
    for j in range(m):
        if arr[i][j] == "0":
            ans[i][j] = 0

for row in ans:
    print(" ".join(map(str, row)))
