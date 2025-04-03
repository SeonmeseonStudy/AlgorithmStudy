M, N, K = map(int, input().split())

grid = [[0] * N for _ in range(M)]

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            grid[i][j] = 1

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(x, y):
    stack = [(x, y)]
    grid[x][y] = 1
    area_size = 1

    while stack:
        cx, cy = stack.pop()
        for d in range(4):
            nx, ny = cx + dx[d], cy + dy[d]
            if 0 <= nx < M and 0 <= ny < N and grid[nx][ny] == 0:
                grid[nx][ny] = 1
                stack.append((nx, ny))
                area_size += 1

    return area_size

areas = []
for i in range(M):
    for j in range(N):
        if grid[i][j] == 0:
            areas.append(dfs(i, j))

print(len(areas))
print(" ".join(map(str, sorted(areas))))
