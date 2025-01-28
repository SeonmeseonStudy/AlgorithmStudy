from collections import deque
def solution(priorities, location):
    answer = 0
    indexPriorities = deque()
    for i, p in enumerate(priorities):
        indexPriorities.append((p, i))
        
    while indexPriorities:
        now = indexPriorities.popleft()
        if any(now[0] < item[0] for item in indexPriorities):
            indexPriorities.append(now)
        else:
            answer += 1
            if now[1] == location:
                return answer
            
priorities = [2, 1, 3, 2]
solution(priorities, location=2)