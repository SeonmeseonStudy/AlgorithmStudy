from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, color, grid, visited, n):
    queue = deque([(x, y)])
    visited[x][y] = True
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == color:
                visited[nx][ny] = True
                queue.append((nx, ny))

def count_regions(grid, n):
    visited = [[False] * n for _ in range(n)]
    regions = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                bfs(i, j, grid[i][j], grid, visited, n)
                regions += 1
    return regions

n = int(input())
grid = [list(input().strip()) for _ in range(n)]

colorblind_grid = []
for row in grid:
    new_row = []
    for c in row:
        if c == 'B':
            new_row.append(c)
        else:
            new_row.append('R')
    colorblind_grid.append(new_row)

normal_count = count_regions(grid, n)
colorblind_count = count_regions(colorblind_grid, n)

print(normal_count, colorblind_count)
