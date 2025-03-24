
M, N, K = map(int, input().split())
grid = [[0] * N for _ in range(M)] 


for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for y in range(y1, y2):  
        for x in range(x1, x2):  
            grid[y][x] = 1  


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dfs_stack(x, y):
    stack = [(x, y)]
    grid[y][x] = 1  
    size = 0

    while stack:
        cx, cy = stack.pop()
        size += 1

        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < N and 0 <= ny < M and grid[ny][nx] == 0:
                grid[ny][nx] = 1 
                stack.append((nx, ny))

    return size


areas = []
for y in range(M):
    for x in range(N):
        if grid[y][x] == 0: 
            areas.append(dfs_stack(x, y))

areas.sort()
print(len(areas))
print(*areas)
