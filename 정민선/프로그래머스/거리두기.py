def solution(places):
    answer = []
    N = 5
    
    def inrange(x, y):
        return 0 <= x < N and 0 <= y < N
    
    def manhattan(r1, c1, r2, c2):
        return abs(r1 - r2) + abs(c1 - c2) <= 2
        
    def isSafe(place):
        dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]
        
        def isPartition(cx, cy, px, py):
            if cx == px:
                for i in range(min(cy, py)+1, max(cy, py)):
                    if place[cx][i] == 'X':
                        return True
            elif cy == py:
                for i in range(min(cx, px)+1, max(cx, px)):
                    if place[i][cy] == 'X':
                        return True
            elif abs(cx - px) == 1 and abs(cy - py) == 1:
                if place[cx][py] == 'X' and place[px][cy] == 'X':
                    return True
            return False

        
        for i in range(N):
            for j in range(N):
                if place[i][j] == 'P':
                    visited = [[False] * N for _ in range(N)]
                    queue = [(i, j)]
                    visited[i][j] = True

                    while queue:
                        x, y = queue.pop(0)
                        
                        for dx, dy in zip(dxs, dys):
                            nx, ny = dx+x, dy+y
                            
                            if inrange(nx, ny) and not visited[nx][ny]:
                                visited[nx][ny] = True
                                
                                if place[nx][ny] == 'P':
                                    if manhattan(i, j, nx, ny):
                                        print(i, j, nx, ny, manhattan(i, j, nx, ny),isPartition(i, j, nx, ny))
                                        if not isPartition(i, j, nx, ny):
                                            return False
                                        
                                if place[nx][ny] == 'O':
                                    queue.append((nx, ny))
        return True
    
    for place in places:
        if isSafe(place):
            answer.append(1)
        else:
            answer.append(0)
            
    return answer