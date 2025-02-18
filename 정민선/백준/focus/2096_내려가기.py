n = int(input())
max_board = [0] * 3
min_board = [0] * 3

for i in range(n):
    x, y, z = map(int, input().split())
    
    pre = max_board[:]
    minpre = min_board[:]
    
    max_board[0] = max(pre[0], pre[1]) + x
    max_board[1] = max(pre[0], pre[1], pre[2]) + y
    max_board[2] = max(pre[1], pre[2]) + z

    min_board[0] = min(minpre[0], minpre[1]) + x
    min_board[1] = min(minpre[0], minpre[1], minpre[2]) + y
    min_board[2] = min(minpre[1], minpre[2]) + z

print(max(max_board), min(min_board))