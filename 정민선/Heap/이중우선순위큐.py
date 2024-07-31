from collections import deque

def solution(operations):
    answer = []
    queue = deque()
    for i in operations:
        s, n = i.split()
        n = int(n)
        if s == "I":
            queue.append(n)
        elif s == "D" and len(queue) > 0:
            if n == 1:
                maxI = max(queue)
                queue.remove(maxI)
            else:
                minI = min(queue)
                queue.remove(minI)

    if len(queue) == 0:
        answer = [0, 0]
    else:
        answer = [max(queue), min(queue)]
            
    return answer

operations = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
solution(operations)