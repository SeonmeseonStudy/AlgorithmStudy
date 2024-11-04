def solution(numbers, hand):
    result = []
        
    keypad = {}
    keypad[1] = (0, 0)
    keypad[2] = (0, 1)  
    keypad[3] = (0, 2) 
    keypad[4] = (1, 0) 
    keypad[5] = (1, 1)  
    keypad[6] = (1, 2) 
    keypad[7] = (2, 0) 
    keypad[8] = (2, 1)  
    keypad[9] = (2, 2)  
    keypad[0] = (3, 1)  
    
    #초기 세팅
    left_pos = (3, 0)  
    right_pos = (3, 2)  
    
    for num in numbers:
        target_pos = keypad[num]
        
        left_dist = abs(left_pos[0] - target_pos[0]) + abs(left_pos[1] - target_pos[1])
        right_dist = abs(right_pos[0] - target_pos[0]) + abs(right_pos[1] - target_pos[1])
        
        if num in [1, 4, 7]:  
            result.append('L')
            left_pos = target_pos
            
        elif num in [3, 6, 9]:  
            result.append('R')
            right_pos = target_pos
            
        else:  
            if left_dist < right_dist:
                result.append('L')
                left_pos = target_pos
                
            elif right_dist < left_dist:
                result.append('R')
                right_pos = target_pos
                
            else: 
                if hand == "left":
                    result.append('L')
                    left_pos = target_pos
                    
                else:
                    result.append('R')
                    right_pos = target_pos

    return ''.join(result)