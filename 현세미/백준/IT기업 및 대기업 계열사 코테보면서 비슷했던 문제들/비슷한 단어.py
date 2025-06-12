from collections import Counter

n = int(input())
words = [input().strip() for _ in range(n)]

base = Counter(words[0])
count = 0

for word in words[1:]:
    compare = Counter(word)

    # 두 Counter의 차이 계산
    diff1 = base - compare
    diff2 = compare - base

    # 총 차이 갯수
    total_diff = sum(diff1.values()) + sum(diff2.values())

    if total_diff == 0 or total_diff == 1:
        count += 1
    elif total_diff == 2 and len(diff1) == 1 and len(diff2) == 1:
        count += 1

print(count)
