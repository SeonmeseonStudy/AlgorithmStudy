def init_counts():
    counts = [0] * 1001
    counts[1] = 1

    for i in range(2, 1001):
        if i % 2 == 0:
            counts[i] = counts[i - 1] + counts[i // 2]
        else:
            counts[i] = counts[i - 1]

    return counts

# 미리 계산한 팰린드롬 개수 저장
palindrome_counts = init_counts()


T = int(input().strip())

for _ in range(T):
    N = int(input().strip())
    print(palindrome_counts[N])
