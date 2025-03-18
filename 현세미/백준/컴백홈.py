r, c, k = map(int, input().split())  
m = [list(input().strip()) for _ in range(r)]  
v = [[0] * c for _ in range(r)]  
cnt = 0  

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def go(x, y, step):
    global cnt
    if (x, y) == (0, c-1):
        if step == k:
            cnt += 1
        return

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        # 범위 안에 있고, 방문 안 했고, 갈 수 있는 길이면 이동
        if 0 <= nx < r and 0 <= ny < c and not v[nx][ny] and m[nx][ny] == '.':
            v[nx][ny] = 1
            go(nx, ny, step + 1)
            v[nx][ny] = 0  

v[r-1][0] = 1
go(r-1, 0, 1)

print(cnt)
