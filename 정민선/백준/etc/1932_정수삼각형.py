n = int(input())
board = [[0] * n for _ in range(n)]
numbers = []
for _ in range(n):
    row = list(map(int, input().split()))
    if len(row) < n:
        row += [0] * (n - len(row))
    numbers.append(row)

board[0][0] = numbers[0][0]
for i in range(1, n):
    board[i][0] = board[i-1][0] + numbers[i][0]

for i in range(1, n):
    for j in range(1, n):
        board[i][j] = max(board[i-1][j] + numbers[i][j], board[i-1][j-1]+numbers[i][j])

print(max(board[-1]))