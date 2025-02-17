N = int(input())
board = [input().split() for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

empty = []
teachers = []

for i in range(N):
    for j in range(N):
        if board[i][j] == "X":
            empty.append((i, j))
        elif board[i][j] == "T":
            teachers.append((i, j))

# 선생님이 학생 볼 수 있는지
def can_see(x, y, d):
    while 0 <= x < N and 0 <= y < N:
        if board[x][y] == "O":
            return False
        if board[x][y] == "S":
            return True
        x += dx[d]
        y += dy[d]
    return False

#장애물에 학생이 가려져 감시 피할 수 있는지
def check():
    for x, y in teachers:
        for d in range(4):
            if can_see(x, y, d):
                return False
    return True

#장애물 3개 배치 함수
def set_wall(count, start):
    if count == 3:
        if check():
            print("YES")
            exit()
        return

    for i in range(start, len(empty)):
        x, y = empty[i]
        board[x][y] = "O"
        set_wall(count + 1, i + 1)
        board[x][y] = "X"

set_wall(0, 0)

print("NO")
