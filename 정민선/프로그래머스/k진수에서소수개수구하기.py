import math

def solution(n, k):
    answer = 0
    
    def change(num, c):
        result = ''
        while num > 0:
            num, mod = divmod(num, c)
            result += str(mod)
        return result[::-1]
    
    result = change(n, k).split('0')
    
    def primenumber(x):
        if x < 2:
            return False
        
        for i in range(2, int(math.sqrt(x) + 1)):
            if (x % i) == 0:
                return False
            
        return True	
    
    for r in result:
        if r == '':
            continue
            
        if primenumber(int(r)):
            answer += 1
    
    return answer