def solution(prices):
    answer = []
    n = len(prices)
    for i in range(n):
        count = 0
        for j in range(i+1, n):
            count += 1
            if prices[j] < prices[i]:
                break
        answer.append(count)
    
    return answer