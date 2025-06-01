def solve():
    S = input()
    q = int(input())

    n = len(S)
    prefix = [[0] * (n + 1) for _ in range(26)]

    for i in range(n):
        for j in range(26):
            prefix[j][i + 1] = prefix[j][i]
        idx = ord(S[i]) - ord('a')
        prefix[idx][i + 1] += 1

    for _ in range(q):
        ch, l, r = input().split()
        l = int(l)
        r = int(r)
        idx = ord(ch) - ord('a')
        count = prefix[idx][r + 1] - prefix[idx][l]
        print(count)

solve()
