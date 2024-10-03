n = int(input())

board = [
    [0]*3 for _ in range(n+1)
]

board[1][0] = 1
board[1][1] = 1
board[1][2] = 1

for i in range(2, n+1):
    board[i][0] = (board[i-1][0] + board[i-1][1] + board[i-1][2])%9901
    board[i][1] = (board[i-1][0] + board[i-1][1])%9901
    board[i][2] = (board[i-1][0] + board[i-1][2])%9901

result = sum(board[n])%9901
print(result)
