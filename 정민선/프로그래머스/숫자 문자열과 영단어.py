def solution(s):
    answer = ''
    text = list(s)
    
    strNumber = {
        'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4', 
        'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'
    }
    
    temp = ''
    for i in range(len(text)):
        try:
            n = int(text[i])
            answer += text[i]
        except:
            temp += text[i]
            
            for sn in strNumber:
                if sn == temp:
                    answer += strNumber[temp]
                    temp = ''

    return int(answer)