from collections import deque

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(M, N, box):
    queue = deque()
    
    for i in range(N):
        for j in range(M):
            if box[i][j] == 1:
                queue.append((i, j, 0))
    
    max_day = 0
    
    while queue:
        x, y, day = queue.popleft()
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < N and 0 <= ny < M and box[nx][ny] == 0:
                box[nx][ny] = 1
                queue.append((nx, ny, day + 1))
                max_day = max(max_day, day + 1)
    
    for i in range(N):
        for j in range(M):
            if box[i][j] == 0:
                return -1
    
    return max_day

def main():
    M, N = map(int, input().split())
    box = [list(map(int, input().split())) for _ in range(N)]
    
    result = bfs(M, N, box)
    
    print(result)

if __name__ == "__main__":
    main()
