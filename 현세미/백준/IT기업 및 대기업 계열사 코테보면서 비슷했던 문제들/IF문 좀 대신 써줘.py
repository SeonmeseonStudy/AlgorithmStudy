import sys
input = sys.stdin.readline

N, M = map(int, input().split())
titles = []
limits = []

for _ in range(N):
    t, l = input().split()
    l = int(l)
    titles.append(t)
    limits.append(l)

powers = [int(input()) for _ in range(M)]

def binary_search(x):
    start, end = 0, N-1
    result = N-1
    while start <= end:
        mid = (start + end) // 2
        if limits[mid] >= x:
            result = mid
            end = mid - 1
        else:
            start = mid + 1
    return result

for p in powers:
    idx = binary_search(p)
    print(titles[idx])
