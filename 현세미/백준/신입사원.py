import sys

def hire(candidates):
    candidates.sort()
    cnt = 1
    min_rank = candidates[0][1]

    for i in range(1, len(candidates)):
        if candidates[i][1] < min_rank:
            cnt += 1
            min_rank = candidates[i][1]

    return cnt

T = int(input())
results = []

for _ in range(T):
    N = int(input())
    candidates = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]

    results.append(str(hire(candidates)))

sys.stdout.write("\n".join(results) + "\n")
