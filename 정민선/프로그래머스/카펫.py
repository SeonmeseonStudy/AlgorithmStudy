def solution(brown, yellow):
    answer = []
    total = brown + yellow
    
    for x in range(3, total//2):
        y = total//x
        
        if (x-2) * (y-2) == yellow:
            answer = [x,y]
    return answer