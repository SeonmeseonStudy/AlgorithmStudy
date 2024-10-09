def solution(m, n, board):
    answer = 0
    for i in range(m):
        board[i] = list(board[i])

    def inrange(x, y):
        return 0 <= x < m and 0 <= y < n

    def bomb(x, y):
        result = True
        value = board[x][y]
        if value == 0:
            return False
        dxs, dys = [0, 1, 1], [1, 0, 1]

        for dx, dy in zip(dxs, dys):
            nx, ny = x+dx, y+dy
            if inrange(nx, ny) and board[nx][ny] == value:
                continue
            else:
                result = False
                break
            
        return result
    
    def down():
        for j in range(n):
            blank = m-1
            
            for i in range(m-1, -1, -1):
                if board[i][j] != 0:
                    board[blank][j] = board[i][j]
                    if blank != i:
                        board[i][j] = 0
                    blank -= 1
    
    while True:
        remove = set()
        for i in range(m):
            for j in range(n):
                if bomb(i, j):
                    remove.update([(i, j), (i, j+1), (i+1, j), (i+1, j+1)])
        
        if not remove:
            break
            
        for x, y in remove:
            board[x][y] = 0
        
        down()
    answer = sum(row.count(0) for row in board)
    return answer

print(solution(6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))