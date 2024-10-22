def solution(n, arr1, arr2):
   
    answer = []
    
    
    for i in range(n):
        # OR 연산한 후 이진수로 변환
        bin_line = bin(arr1[i] | arr2[i])[2:]
        
        bin_line = bin_line.zfill(n)
        
        map_line = bin_line.replace('1', '#').replace('0', ' ')
        
        answer.append(map_line)
    
    return answer
