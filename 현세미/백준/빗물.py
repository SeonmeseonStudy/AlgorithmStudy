H, W = map(int, input().split())
heights = list(map(int, input().split()))

water_trapped = 0

for i in range(W):
    left_max = 0
    for j in range(i + 1):
        if heights[j] > left_max:
            left_max = heights[j]

    right_max = 0
    for j in range(i, W):
        if heights[j] > right_max:
            right_max = heights[j]

    water_at_i = min(left_max, right_max) - heights[i]
    
    if water_at_i > 0:
        water_trapped += water_at_i

print(water_trapped)
