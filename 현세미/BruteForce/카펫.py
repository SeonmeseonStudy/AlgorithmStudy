def solution(brown, yellow):
    total = brown + yellow 
    width = 0  
    height = 0
    
    for i in range(3, total // 3 + 1):
        if total % i == 0:
            width = i  
            height = total // i  
            if (width - 2) * (height - 2) == yellow:
  
                break
    
    return [max(width, height), min(width, height)]  
