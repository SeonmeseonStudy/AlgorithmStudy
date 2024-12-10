n = int(input())

for _ in range(n):
    days = int(input())
    prices = list(map(int, input().split()))
    
    maxPrice = prices[-1]
    total = 0 

    for i in range((days - 1), -1, -1):
        if prices[i] > maxPrice:
            maxPrice = prices[i]
        else:
            total += (maxPrice - prices[i])
        
    print(total)