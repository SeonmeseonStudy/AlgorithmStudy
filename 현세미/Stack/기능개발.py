import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    days = deque()
    for p, s in zip(progresses, speeds):
        days.append(math.ceil((100 - p) / s))
    
    current = days.popleft()
    count = 1
    
    while days:
        next_day = days.popleft()
        
        if next_day <= current:
            count += 1
        else:
            answer.append(count)
            current = next_day
            count = 1
    
    answer.append(count) 
    
    return answer
