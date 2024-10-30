#프로그래머스 - 두 큐의 합 같게 만들기
from collections import deque

def solution(queue1, queue2):
    q1, q2 = deque(queue1), deque(queue2)
    s1, s2 = sum(q1), sum(q2)
    total = s1 + s2
    
    if total % 2 != 0:
        return -1
    
    target = total // 2
    max_moves = len(queue1) + len(queue2) +2
    answer = 0
    
    while answer <= max_moves:
        if s1 == target:
            return answer

        if s1 > s2:
            i = q1.popleft()
            q2.append(i)
            s1 -= i
            s2 += i
        else:
            i = q2.popleft()
            q1.append(i)
            s1 += i
            s2 -= i
        
        answer += 1

    return -1
