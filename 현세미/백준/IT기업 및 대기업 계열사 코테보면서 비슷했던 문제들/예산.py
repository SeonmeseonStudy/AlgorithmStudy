N = int(input())
requests = list(map(int, input().split()))
M = int(input())

left, right = 0, max(requests)
answer = 0

while left <= right:
    mid = (left + right) // 2
    allocated = 0
    
    for request in requests:
        if request > mid:
            allocated += mid
        else:
            allocated += request
    
    if allocated <= M:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)
