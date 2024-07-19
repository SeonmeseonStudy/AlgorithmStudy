def solution(prices):
    answer = []
    
    for i in range(len(prices)):
        time = 0
        for j in range(i + 1, len(prices)):
            time += 1
            if prices[j] < prices[i]:
                break
        answer.append(time)
    
    return answer