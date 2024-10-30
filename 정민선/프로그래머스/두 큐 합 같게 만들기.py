from collections import deque

def solution(queue1, queue2):
    target = (sum(queue1) + sum(queue2))//2
    
    array1, array2 = deque(queue1), deque(queue2)
    sum1, sum2 = sum(array1), sum(array2)
    
    loop = len(queue1) * 2 + len(queue2) * 2
    count = 0
    
    while count <= loop:
        if sum1 == target:
            return count
        
        if sum1 > sum2:
            x = array1.popleft()
            array2.append(x)
            sum1 -= x
            sum2 += x
        else:
            x = array2.popleft()
            array1.append(x)
            sum1 += x
            sum2 -= x
        count += 1
    
    return -1