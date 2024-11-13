from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        allCombinations = []
        for order in orders:
            order = sorted(order)
            combination = combinations(order, c)
            allCombinations += combination
            
        combination_counts = Counter(allCombinations)
        
        if combination_counts:
            maxCount = max(combination_counts.values())
            if maxCount > 1:
                for combination, count in combination_counts.items():
                    if count == maxCount:
                        answer.append("".join(combination))

    answer = sorted(answer)
    return answer
