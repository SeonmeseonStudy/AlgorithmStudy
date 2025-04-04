n = int(input())
arr = list(map(int, input().split()))

left = 0
right = n - 1
best_sum = float('inf')
best_pair = (0, 0)

while left < right:
    current_sum = arr[left] + arr[right]
    
    if abs(current_sum) < abs(best_sum):
        best_sum = current_sum
        best_pair = (arr[left], arr[right])
    
    if current_sum < 0:
        left += 1
    elif current_sum > 0:
        right -= 1
    else:
        break

print(best_pair[0], best_pair[1])
