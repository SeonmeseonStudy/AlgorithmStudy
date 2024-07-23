from itertools import permutations

def solution(k, d):
    answer = 0
    
    dun_len = len(d)
    
    for permute in permutations(d, dun_len):
        hp = k
        count = 0 
    
        
        for pm in permute:

            if hp >= pm[0]:
                hp -= pm[1]
                count += 1
            
            if count > answer:
                answer = count
    
    return answer