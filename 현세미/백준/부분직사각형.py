def solve(n, m, g):
    cnt = [0] * 26  # 알파벳 개수 

    for r in range(2 * n):
        for c in range(2 * m):
            ch = g[r % n][c % m]  # 원본 문자
            idx = ord(ch) - ord('A')
            
            #해당 문자가 포함되는 직사각형 개수 계산
            num = (r + 1) * (c + 1) * (2 * n - r) * (2 * m - c)
            cnt[idx] += num

    for x in cnt:
        print(x)

n, m = map(int, input().split())
g = [input().strip() for _ in range(n)]

solve(n, m, g)
