mport sys
input = sys.stdin.readline

N, M = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(N)]

INF = float('inf')
#방향 3가지
dp = [[[INF]*3 for _ in range(M)] for _ in range(N)]


for j in range(M):
    for d in range(3):
        dp[0][j][d] = space[0][j]

# d = 0: ↙, d = 1: ↓, d = 2: ↘
dx = [1, 1, 1]
dy = [-1, 0, 1]

for i in range(1, N):
    for j in range(M):
        for d in range(3):  #
            nj = j + dy[d]
            if 0 <= nj < M:
                for prev_d in range(3):
                    if prev_d != d:
                        dp[i][j][d] = min(dp[i][j][d], dp[i-1][nj][prev_d] + space[i][j])

answer = INF
for j in range(M):
    for d in range(3):
        answer = min(answer, dp[N-1][j][d])

print(answer)
