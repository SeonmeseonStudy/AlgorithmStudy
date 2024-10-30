# 백준 - 20922 겹치는 건 싫어
n, k = map(int, input().split())
arr = list(map(int, input().split()))

answer = 0
start, end = 0, 0
counter = [0] * (max(arr) + 1)

while end < n:
    if counter[arr[end]] < k:
        counter[arr[end]] += 1
        end += 1
    else:
        counter[arr[start]] -= 1
        start += 1

    answer = max(answer, end - start)

print(answer)
