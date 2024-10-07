def solution(n, t, m, p):
    answer = ''
    MAXV = (t*m)+1
    numbers = "0123456789ABCDEFG"
    
    strNumber = '0'
    def changeNumber(number, n):
        result = ''
        while number > 0:
            number, mod = divmod(number, n)
            result += numbers[mod]
            
        return result[::-1]
    
    for i in range(1, MAXV):
        strNumber += changeNumber(i, n)
        
    for i in range(p-1, MAXV-1, m):
        answer += strNumber[i]
        
    return answer