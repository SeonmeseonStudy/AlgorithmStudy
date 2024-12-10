n = int(input())
numbers = list(map(int, input().split()))
limit = int(input())

right = max(numbers)+1
left = limit//n

answer = 0
while (left < right):
    mid = (left+right)//2
    total = 0
    for num in numbers:
        total += min(num, mid)
        
    if total <= limit:
        answer = mid
        left = mid + 1
    else:
        right = mid
    
print(answer)