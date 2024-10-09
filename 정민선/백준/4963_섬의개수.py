while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    board = [list(input().split()) for _ in range(h)]
    visited = [[False]*w for _ in range(h)]
    count = 0
    
    def in_range(x, y):
        return 0 <= x < h and 0 <= y < w
    
    def dfs(x, y):
        stack = [(x, y)]
        visited[x][y] = True
        dxs, dys = [0, 0, -1, 1, -1, 1, -1, 1], [-1, 1, 0, 0, -1, -1, 1, 1]
        
        while stack:
            cx, cy = stack.pop()
            for dx, dy in zip(dxs, dys):
                nx, ny = cx + dx, cy + dy
                if in_range(nx, ny) and not visited[nx][ny] and board[nx][ny] == '1':
                    visited[nx][ny] = True
                    stack.append((nx, ny))
            
    for i in range(h):
        for j in range(w):
            if not visited[i][j] and board[i][j] == '1':
                dfs(i, j)
                count += 1
    
    print(count)