n = int(input())
roads = list(map(int, input().split()))
prices = list(map(int, input().split()))

total_cost = 0
min_price = prices[0]

for i in range(n - 1):
    min_price = min(min_price, prices[i])
    total_cost += min_price * roads[i]

print(total_cost)
