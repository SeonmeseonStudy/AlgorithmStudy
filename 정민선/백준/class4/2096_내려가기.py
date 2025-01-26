import sys
N = int(sys.stdin.readline().strip())

max_board = [0] * 3
min_board = [0] * 3

for i in range(N):
    x, y, z = map(int, sys.stdin.readline().split())
    
    prev_max = max_board[:]
    prev_min = min_board[:]

    max_board[0] = max(prev_max[0], prev_max[1]) + x
    max_board[1] = max(prev_max[0], prev_max[1], prev_max[2]) + y
    max_board[2] = max(prev_max[1], prev_max[2]) + z

    min_board[0] = min(prev_min[0], prev_min[1]) + x
    min_board[1] = min(prev_min[0], prev_min[1], prev_min[2]) + y
    min_board[2] = min(prev_min[1], prev_min[2]) + z

print(max(max_board), min(min_board))
