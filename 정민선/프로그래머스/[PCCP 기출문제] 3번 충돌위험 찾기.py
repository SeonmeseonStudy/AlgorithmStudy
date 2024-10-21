from collections import deque
import sys

def solution(points, routes):
    answer = 0
    
    def move(route):
        path = []
        for i in range(1, len(route)):
            sx, sy = points[route[i-1]-1]
            ex, ey = points[route[i]-1]
            
            if len(path) == 0: # 맨처음 시작만
                path.append((sx, sy))
            
            while (sx != ex):
                if sx > ex:
                    sx -= 1
                else:
                    sx += 1
                path.append((sx, sy))
                
            while (sy != ey):
                if sy > ey:
                    sy -= 1
                else:
                    sy += 1
                path.append((sx, sy))
        
        return path
    
    path = []
    time = 0
    
    for route in routes:
        result = move(route)
        time = max(time, len(result))
        path.append(result)
    
    
    for i in range(time):
        result = dict()
        for route in path:
            if i < len(route):  
                if route[i] in result:
                    result[route[i]] += 1
                else:
                    result[route[i]] = 1

        for pos, cnt in result.items():
            if cnt > 1:
                answer += 1
        
    return answer