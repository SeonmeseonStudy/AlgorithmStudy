from collections import deque

def solution(n, times):
    answer = 0
    left = 1 # 문제가 1분 이상이니까 min 안쓰고 그냥 1
    right = max(times) * n
    person = 0
    
    while left <= right:
        person = 0
        mid = (left+right) // 2
        for time in times:
            person += mid // time
            if person >= n:
                break
        if person >= n: # 심사가 아직 안 끝난 경우 포함, 양쪽 끝 범위 점점 줄이거나 늘리기
            answer = mid
            right = mid-1
        elif person < n:
            left = mid+1
        
    return answer